/**
 * 
 */
package com.hargun.unittesting.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hargun.unittesting.junit.StringHelper;

/**
 * @author hargun.suri
 *
 */
public class StringHelperBeforeAftertBasicExampleTest {

	/**
	 * @Before - Set up or initialise the basic data required for testing or
	 *         setup the values which needs to be used.
	 * 
	 * @Test - Perform required tests.
	 * 
	 * @After - Release DB connections and parameters.
	 */
	StringHelper helper;

	@Before
	public void before() {
		System.out.println("Inside before method");
		helper = new StringHelper();
	}

	/*
	 * Expected value to be returned by method is true
	 */
	@Test
	public void areFirstAndLastTwoCharactersTheSame_test() {
		System.out.println("Inside test method - areFirstAndLastTwoCharactersTheSame_test");
		assertEquals(true, helper.areFirstAndLastTwoCharactersTheSame("AB"));

	}

	/*
	 * Expected value to be returned by method is CD
	 */
	@Test
	public void truncateAInFirst2Positions_test() {
		System.out.println("Inside test method - truncateAInFirst2Positions_test");
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	@After
	public void after() {
		System.out.println("Inside after method");
		helper = null;
	}

	/**
	 * 
	 * Result in console :
	 * 
	 * Inside before method
	 * 
	 * Inside test method - areFirstAndLastTwoCharactersTheSame_test
	 * 
	 * Inside after method
	 * 
	 * Inside before method
	 * 
	 * Inside test method - truncateAInFirst2Positions_test
	 * 
	 * Inside after method
	 * 
	 */

}