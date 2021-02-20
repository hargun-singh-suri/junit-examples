package com.hargun.junit.lecture1;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hargun.unittesting.junit.StringHelper;

/**
 * @author hargun.suri
 *
 */
public class StringHelperAssertBasicExampleTest {

	/********************
	 * Testing truncateAInFirst2Positions method
	 ****************/

	/**
	 * Failing unit test but not error
	 */
	@Test
	public void stringHelperTestCase1() {
		// fail("Not yet implemented");
	}

	/**
	 * assertEquals - argument_1 -> Expected, argument_2 -> Actual Therefore
	 * argument_1 is telling you about what should be the result argument_2 is
	 * telling you about what actually is the result.
	 */
	@Test
	public void stringHelperTestCase2() {
		assertEquals("ABC", "ABC");
	}

	/**
	 * For below execution expectedValue is the value which we are expecting
	 * after execution of truncateAInFirst2Positions with some passed argument
	 * value.
	 */
	@Test
	public void stringHelperTestCase3() {
		StringHelper sh = new StringHelper();
		String actualValue = sh.truncateAInFirst2Positions("AACD");
		String expectedValue = "CD";
		assertEquals(expectedValue, actualValue);
	}

	/**
	 * Writing above test case in 1 line i.e. refactoring to 1 liner
	 */
	@Test
	public void stringHelperTestCase4() {
		StringHelper sh = new StringHelper();
		assertEquals("CD", sh.truncateAInFirst2Positions("AACD"));
	}

	/**
	 * Writing sequence of execution
	 */
	@Test
	public void stringHelperTestCase5() {
		StringHelper sh = new StringHelper();
		assertEquals("CD", sh.truncateAInFirst2Positions("AACD"));
		assertEquals("CD", sh.truncateAInFirst2Positions("ACD"));
		assertEquals("CDEF", sh.truncateAInFirst2Positions("CDEF"));
		assertEquals("CDAA", sh.truncateAInFirst2Positions("CDAA"));
	}

	/**
	 * Error case org.junit.ComparisonFailure: expected:<[XYZA]> but
	 * was:<[UYTGH]>
	 * 
	 */
	@Test
	public void stringHelperTestCase6() {
		StringHelper sh = new StringHelper();
		assertEquals("XYZA", sh.truncateAInFirst2Positions("UYTGH"));
	}

	/*
	 * Better make StringHelper sh = new StringHelper(); as common on class
	 * level As the code is mostly processing the input and returning the result
	 * so here the processing on input string is done and in a similar manner
	 * the comparison of JSON request can be done which means If we send request
	 * to some external end point with manually created request JSON we should
	 * expect output to be OK.
	 */

	/********************
	 * Testing areFirstAndLastTwoCharactersTheSame method
	 ****************/
	StringHelper sh = new StringHelper();
	// ABCD -> False,ABAB -> TRUE, AB -> TRUE, A -> FALSE

	@Test
	public void areFirstAndLastTwoCharactersTheSame_ABCD() {
		assertEquals(false, sh.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@Test
	public void areFirstAndLastTwoCharactersTheSame_ABAB() {
		assertEquals(true, sh.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

	@Test
	public void areFirstAndLastTwoCharactersTheSame_AB() {
		assertEquals(true, sh.areFirstAndLastTwoCharactersTheSame("AB"));
	}

	@Test
	public void areFirstAndLastTwoCharactersTheSame_A() {
		assertEquals(true, sh.areFirstAndLastTwoCharactersTheSame("A"));
	}

	/**
	 * Test a JUNIT that should return a negative result
	 * 
	 * Test will pass
	 */
	@Test
	public void areFirstAndLastTwoCharactersTheSame_basicNegative() {
		assertTrue(sh.areFirstAndLastTwoCharactersTheSame("A"));
	}

	/**
	 * Test a JUNIT that should return a positive result Test will pass expected
	 * and actual both are same
	 */
	@Test
	public void areFirstAndLastTwoCharactersTheSame_basicPositive() {
		assertFalse(sh.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	/**
	 * Test a JUNIT that should return a negative result but the processing
	 * returns positive result therefore log a error message
	 */
	@Test
	public void areFirstAndLastTwoCharactersTheSame_basicNegativeWithInfo() {
		assertTrue("Test Case failing", sh.areFirstAndLastTwoCharactersTheSame("A"));
	}
}