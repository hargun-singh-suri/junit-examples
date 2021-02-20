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
public class PerformanceExampleTest {

	/**
	 * Execution of method must be completed within 100 ms
	 */
	@Test(timeout = 100)
	public void test_executionMustCompleteWithinTime_1() {
		int[] rank = { 25, 16, 96 };

		for (int i = 0; i <= 10000000; i++) {
			rank[0] = i;
			Arrays.sort(rank);
		}
		/*
		 * Output :
		 * 
		 * org.junit.runners.model.TestTimedOutException: test timed out after
		 * 100 milliseconds
		 */
	}

	@Test(timeout = 100)
	public void test_executionMustCompleteWithinTime_2() {
		int[] rank = { 25, 16, 96 };

		for (int i = 0; i <= 100; i++) {
			rank[0] = i;
			Arrays.sort(rank);
		}
		/*
		 * Output :
		 * 
		 * Okay
		 */
	}

	@Test(timeout = 100)
	public void test_executionMustCompleteWithinTime_3() throws InterruptedException {

		Thread.sleep(1000);

		/*
		 * Output :
		 * 
		 * org.junit.runners.model.TestTimedOutException: test timed out after
		 * 100 milliseconds
		 */
	}

	/**
	 * Looks like the first failure case is of time out, which is the reason for
	 * JUunit failure
	 * 
	 * @throws InterruptedException
	 */
	@Test(timeout = 100, expected = InterruptedException.class)
	public void test_executionMustCompleteWithinTime_4() throws InterruptedException {

		Thread.sleep(1000);

		/*
		 * Output :
		 * 
		 * org.junit.runners.model.TestTimedOutException: test timed out after
		 * 100 milliseconds
		 */
	}

}
