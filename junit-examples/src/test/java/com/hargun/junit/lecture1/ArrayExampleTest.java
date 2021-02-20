/**
 * 
 */
package com.hargun.junit.lecture1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author hargun.suri
 *
 */
public class ArrayExampleTest {

	@Test
	public void test_example1() {
		int[] actual = { 20, 30, 90, 100, 40, 50 };
		int[] expected = { 20, 30, 40, 50, 90, 100 };

		assertArrayEquals(expected, actual);

		/*
		 * Output - arrays first differed at element [2]; expected:<40> but
		 * was:<90>
		 */
	}

	@Test
	public void test_example_2() {
		int[] actual = { 20, 30, 90, 100, 40, 50 };
		int[] expected = { 20, 30, 40, 50, 90, 100 };
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
	}

}
