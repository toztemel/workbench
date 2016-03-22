package grep;

import org.junit.Test;


public class GrepTest {

	@Test
	public void testExecute() throws Exception {
		Grep grep = new Grep();
		grep.execute(",-001463807644:11df416:13bacbd402b:-7735", "/home/tayfuno/Desktop/SmscEdr/sampleEdr.txt");
	}

}
