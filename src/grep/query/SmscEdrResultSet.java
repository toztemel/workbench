package grep.query;

import java.util.HashSet;
import java.util.Set;

public class SmscEdrResultSet {

	private Set<SmscEdr> edrs;
	private EdrStringParser parser;
	
	public SmscEdrResultSet() {
		edrs = new HashSet<SmscEdr>();
		parser = new EdrStringParser();
	}
	
	public boolean containsMsgId (String msgId) {
		for (SmscEdr edr : edrs)
			if (edr.getCdrKey().equals(msgId))
				return true;
		return false;
	}
	
	public boolean containsEdrString (String edrStr) {
		SmscEdr edrObj = parser.parseEdrString(new EdrString(edrStr));
		for (SmscEdr edr : edrs)
			if (edr.getEdrString().equals(edrObj.getEdrString()))
				return true;
		return false;
	}

	public void addEdrString (EdrString sResult) {
//		TODO count result items here
		edrs.add(parser.parseEdrString(sResult));
	}
	
	public Set<SmscEdr> getAllEdrs () {
		return edrs;
	}

	public boolean isEmpty() {
		return edrs.isEmpty();
	}

	public int size() {
		return edrs.size();
	}

}