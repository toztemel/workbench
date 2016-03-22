package query.zgrep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import query.Address;
import query.EdrString;
import query.MessageId;
import query.MessagingError;
import query.SearchEngine;
import query.SmscEdrResultSet;

public class ZGrepSearchEngine implements SearchEngine {

	private FilenameFilter zippedEdrFileNameFilter;
	private File[] edrFiles;

	public ZGrepSearchEngine() {
		zippedEdrFileNameFilter = new FilenameFilter() {

			@Override
			public boolean accept(File fileDirectory, String fileName) {
				if (isZippedSmscEdrName(fileName))
					return true;
				return false;
			}

			private boolean isZippedSmscEdrName(String fileName) {
				return fileName.startsWith("SMSC_")
						&& fileName.endsWith(".zip");
			}
		};
		
		setSearchDirectory("/home/tayfuno/Desktop/SmscEdr/");
	}

	protected void setSearchDirectory(String directory) {
		File edrDirectory = new File(directory);
		edrFiles = edrDirectory.listFiles(zippedEdrFileNameFilter);
	}

	protected void setSearchFile(String absoluteFilePath) {
		edrFiles = new File[1];
		edrFiles[0] = new File(absoluteFilePath.trim());
	}

	protected boolean isFileEmpty() {
		return edrFiles[0].getTotalSpace() <= 0;
	}

	private void executeSearch(String searchString, SmscEdrResultSet resultSet) {
		try {
			for (File file : edrFiles) {
				String sGrepCommand = getZGrepCommand(searchString, file.getAbsolutePath());
				// Execute UNIX command
				Process pGrep = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", sGrepCommand });
				
//				ProcessBuilder pb = new ProcessBuilder(new String[] { "/bin/sh", "-c", sGrepCommand });
//				pb = pb.redirectErrorStream(true);
//			    Process pGrep = pb.start();
			    InputStream inputStream = pGrep.getInputStream();
			    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader brStdInput = new BufferedReader(inputStreamReader);

				// Get the first line
				String sResult = brStdInput.readLine();
				while (sResult != null) {
					System.out.println("From std IN: " + sResult);
					if (null != sResult)
						resultSet.addEdrString(new EdrString(sResult));
					sResult = brStdInput.readLine();
				}

				int iTerminationStatus = pGrep.waitFor();
				if (pGrep.exitValue() == 1) {
					System.err.println("ZGrep Command no match.");
					System.err.println("Termination status=" + iTerminationStatus);
				} else if (pGrep.exitValue() != 0) {
					System.err.println("ZGrep Command failed.");
					System.err.println("Termination status=" + iTerminationStatus);
					System.err.println("Exit value=" + pGrep.exitValue());
				}
				System.out.println("Command executed");
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private String getZGrepCommand(String searchString, String searchFile) {
		String sGrepCommand = "zgrep -e \"" + searchString + "\" " + searchFile;
		System.out.println("Command: " + sGrepCommand);
		return sGrepCommand;
	}

	protected int getEdrFileCount() {
		return edrFiles.length;
	}

	@Override
	public SmscEdrResultSet searchEdrWithMessageId(MessageId messageId) {
		SmscEdrResultSet resultSet = new SmscEdrResultSet();
		executeSearch(messageId.getMessageId(), resultSet);
		System.out.println("Search Completed. Items found:" + resultSet.size());
		return resultSet;
	}

	@Override
	public SmscEdrResultSet searchEdrWithSingleAddress(Address anAddress) {
		return null;
	}

	@Override
	public SmscEdrResultSet searchEdrWithABParties(Address aParty, Address bParty) {
		//		,905065841341,905548360445,
		StringBuffer buffer = new StringBuffer();
		buffer.append("\\(,");
		buffer.append(aParty.getAddress());
		buffer.append(",");
		buffer.append(bParty.getAddress());
		buffer.append(",\\)\\|\\(,");
		buffer.append(bParty.getAddress());
		buffer.append(",");
		buffer.append(aParty.getAddress());
		buffer.append(",\\)");
		String searchString = buffer.toString();
		SmscEdrResultSet resultSet = new SmscEdrResultSet();
		executeSearch(searchString, resultSet);
		System.out.println("Search Completed. Items found:" + resultSet.size());
		return resultSet;
	}

	@Override
	public SmscEdrResultSet searchEdrWithErrorCode(MessagingError errorParameters) {
		StringBuffer buffer = new StringBuffer();
//		zgrep -e "\(,[[:alnum:]]*\)\{9\},1,3,1" SMSC_1_7394_20130102000101.zip 
		buffer.append("\\(,[[:alnum:]]*\\)\\{9\\}");
		buffer.append(",1");
		buffer.append(",").append(errorParameters.getErrorContext());
		buffer.append(",").append(errorParameters.getErrorCode());
		buffer.append(",");
		Pattern searchPattern = Pattern.compile(buffer.toString());
		SmscEdrResultSet resultSet = new SmscEdrResultSet();
		executeSearch(searchPattern.pattern(), resultSet);
		System.out.println("Search Completed. Items found:" + resultSet.size());
		return resultSet;
	}
}