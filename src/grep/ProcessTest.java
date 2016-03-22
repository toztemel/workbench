

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

public class ProcessTest {

	@Test
	public void testProcess() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOutputStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInputStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetErrorStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitFor() {
		fail("Not yet implemented");
	}

	@Test
	public void testExitValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testDestroy() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeparateParameters() throws Exception {
		System.out.println("test 1");
		execute(new String[] { "/bin/bash", "-c", "zgrep", "-e",
				"\"\\(,[[:alnum:]]*\\)\\{9\\},1,3,31,\"",
				"/home/tayfuno/Desktop/SmscEdr/SMSC_2_9072_20121218090101.zip" });
	}

	@Test
	public void testWholeCommandInOneParameter() throws Exception {
		System.out.println("test 8");
		execute(new String[] {
				"/bin/bash",
				"-c",
				"zgrep -e \"\\(,[[:alnum:]]*\\)\\{9\\},1,3,31,\" /home/tayfuno/Desktop/SmscEdr/SMSC_2_9072_20121218090101.zip" });
		System.out.println("finished ");
	}

	private void execute(String... strArray) {
		try {
			Process pGrep = Runtime.getRuntime().exec(strArray);

			BufferedReader brStdInput = new BufferedReader(
					new InputStreamReader(pGrep.getInputStream()));
			String sResult = brStdInput.readLine();
			while (sResult != null) {
				System.out.println("From std IN: " + sResult);
				sResult = brStdInput.readLine();
			}

			BufferedReader brErrInput = new BufferedReader(
					new InputStreamReader(pGrep.getErrorStream()));
			sResult = brErrInput.readLine();
			while (sResult != null) {
				System.out.println("From Err : " + sResult);
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

			pGrep.destroy();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testStreamCopyIOUtils() throws Exception {
		final Process process = Runtime
				.getRuntime()
				.exec(new String[] {
						"/bin/bash",
						"-c",
						"zgrep -e \"\\(,[[:alnum:]]*\\)\\{9\\},1,3,31,\" /home/tayfuno/Desktop/SmscEdr/SMSC_2_9072_20121218090101.zip" });

		new Thread(new Runnable() {
			public void run() {
				try {
					IOUtils.copy(process.getInputStream(), System.out);
				} catch (IOException e) {
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				try {
					IOUtils.copy(process.getErrorStream(), System.err);
				} catch (IOException e) {
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				try {
					IOUtils.copy(System.in, process.getOutputStream());
				} catch (IOException e) {
				}
			}
		}).start();

		process.waitFor();

	}

	@Test
	public void testStreamPipeOut() throws Exception {
		try {
			Process pGrep = Runtime
					.getRuntime()
					.exec(new String[] {
							"/bin/bash",
							"-c",
							"zgrep -e \"\\(,[[:alnum:]]*\\)\\{9\\},1,3,31,\" /home/tayfuno/Desktop/SmscEdr/SMSC_2_9072_20121218090101.zip" });
			pipeOutput(pGrep);
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

			// BufferedReader brStdInput = new BufferedReader(new
			// InputStreamReader(pGrep.getInputStream()));
			// String sResult = brStdInput.readLine();
			// while (sResult != null) {
			// System.out.println("From std IN: " + sResult);
			// sResult = brStdInput.readLine();
			// }
			//
			// BufferedReader brErrInput = new BufferedReader(new
			// InputStreamReader(pGrep.getErrorStream()));
			// sResult = brErrInput.readLine();
			// while (sResult != null) {
			// System.out.println("From Err : " + sResult);
			// sResult = brStdInput.readLine();
			// }
			pGrep.destroy();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void pipeOutput(Process process) {
		pipe(process.getErrorStream(), System.err);
		pipe(process.getInputStream(), System.out);
	}

	private static void pipe(final InputStream src, final PrintStream dest) {
		new Thread(new Runnable() {
			public void run() {
				try {
					byte[] buffer = new byte[1024];
					for (int n = 0; n != -1; n = src.read(buffer)) {
						dest.write(buffer, 0, n);
					}
				} catch (IOException e) { // just exit
				}
			}
		}).start();
	}

}
