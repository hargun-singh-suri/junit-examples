/**
 * 
 */
package com.hargun.junit.lecture1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hargun.unittesting.junit.StringHelper;

/**
 * @author hargun.suri
 *
 */
public class StringHelperBeforeAfterClassExampleTest {

	/**
	 * 
	 * @BeforeClass/@AfterClass must be annotated over static method
	 * 
	 * 
	 */
	static StringHelper helper;

	@BeforeClass
	public static void before() {
		System.out.println("Inside before method");
		helper = new StringHelper();

	}

	@Test
	public void areFirstAndLastTwoCharactersTheSame_test() {
		System.out.println("Inside test method - areFirstAndLastTwoCharactersTheSame_test");
		assertEquals(true, helper.areFirstAndLastTwoCharactersTheSame("AB"));

	}

	@Test
	public void truncateAInFirst2Positions_test() {
		System.out.println("Inside test method - truncateAInFirst2Positions_test");
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	@AfterClass
	public static void after() {
		System.out.println("Inside after method");
		helper = null;
	}

	/**
	 * Inside before method
	 * 
	 * Inside test method - areFirstAndLastTwoCharactersTheSame_test
	 * 
	 * Inside test method - truncateAInFirst2Positions_test
	 * 
	 * Inside after method
	 * 
	 */

}
