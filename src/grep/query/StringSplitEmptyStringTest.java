package query;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class StringSplitEmptyStringTest {

	@Test
	public void testStringSplit2Fields() {
		String edrString = "a,b";
		String[] fieldArray = edrString.split(",");
		
		assertEquals (2, fieldArray.length);
	}

	@Test
	public void testStringSplit2Full1EmptyFields() {
		String edrString = "a,b,";
		String[] fieldArray = edrString.split(",", -1);
		
		assertEquals (3, fieldArray.length);
	}
	
	@Test
	public void testPattern () {
		String string = "baaa,a";
		Pattern p = Pattern.compile(".*,.*");
		Matcher m = p.matcher(string);
		assertTrue(m.matches());
	}
	
	@Test
	public void testMatcher() {
	}

	@Test
	public void testStringSplit3Full1EmptyFields() {
		String edrString = "a,b,,c";
		String[] fieldArray = edrString.split(",", -1);
		
		assertEquals (4, fieldArray.length);
	}

	@Test
	public void testStringSplitEmptyFieldsAtTheEnds() {
		String edrString = ",a,b,c,";
		String[] fieldArray = edrString.split("," , -1);
		
		assertEquals (5, fieldArray.length);
	}

	@Test
	public void testStringSplitEmptyFields() {
		String edrString = ",a,,c,";
		String[] fieldArray = edrString.split(",", -1);
		
		assertEquals (5, fieldArray.length);
	}


}
