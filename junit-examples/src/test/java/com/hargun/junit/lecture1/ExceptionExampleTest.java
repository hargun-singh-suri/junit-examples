/**
 * 
 */
package com.hargun.junit.lecture1;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author hargun.suri
 *
 */
public class ExceptionExampleTest {

	@Test
	public void test_exceptionIsRaisedAndJunitIsNotExpectingException() {
		int numerator = 1;
		int denominator = 0;
		int result = numerator / denominator;

		/*
		 * Output will be
		 * 
		 * java.lang.ArithmeticException: / by zero
		 * 
		 */
	}

	@Test(expected = ArithmeticException.class)
	public void test_exceptionIsRaisedAndJunitIsExpectingException() {
		int numerator = 1;
		int denominator = 0;
		int result = numerator / denominator;

		/*
		 * Output will be - PASS
		 */
	}

	@Test(expected = NullPointerException.class)
	public void test_exceptionIsRaisedAndJunitIsExpectingException_1() {
		int[] values = null;
		Arrays.sort(values);

		/*
		 * Output will be - PASS
		 */
	}

	@Test(expected = ArithmeticException.class)
	public void test_exceptionIsRaisedAndJunitIsExpectingDifferentException() {
		int[] values = null;
		Arrays.sort(values);

		/*
		 * Output will be - java.lang.Exception: Unexpected exception,
		 * expected<java.lang.ArithmeticException> but
		 * was<java.lang.NullPointerException>
		 */
	}

}
