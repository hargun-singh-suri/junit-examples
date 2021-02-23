/**
 * 
 */
package com.hargun.unittesting.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hargun.unittesting.junit.StringHelper;

/**
 * @author hargun.suri
 *
 */
@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	StringHelper helper = new StringHelper();

	private String input;
	private String expected;

	public StringHelperParameterizedTest(String input, String expected) {
		super();
		this.input = input;
		this.expected = expected;
	}

	/**
	 * Pass as many parameters we need
	 * 
	 * Make sure the sequence of parameter must match with the sequence of
	 * constructor created for the class associated with parameters in our case
	 * first element is input and second is expected.
	 */
	@Parameters
	public static List<String[]> parameters() {
		String[][] params = { { "AACD", "CD" }, { "CDEF", "CDEF" }, { "CDAA", "A" } };
		return Arrays.asList(params);
	}

	@Test
	public void test() {
		assertEquals(expected, helper.truncateAInFirst2Positions(input));
	}

	/**
	 * Output : org.junit.ComparisonFailure: expected:<[]A> but was:<[CDA]A>
	 */
}
