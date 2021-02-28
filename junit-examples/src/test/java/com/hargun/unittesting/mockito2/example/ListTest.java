/**
 * 
 */
package com.hargun.unittesting.mockito2.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author hargun.suri
 *
 *
 *         Mock methods of list interface
 *
 */
public class ListTest {

	/**
	 * Mock a List class method size to return value of 10.
	 */
	@Test
	public void mockListMethod_size() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}

	/**
	 * The values are returned here after each call which mean thenReturn(10)
	 * will point to assertEquals(10, list.size()) where as enReturn(20) will
	 * point to next test case assertEquals(20, list.size()); if for r.g. value
	 * here is diff than 20 then it will be JUNIT failure.
	 */
	@Test
	public void mockListMethod_size_multipleValue() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20).thenReturn(30);

		assertEquals(10, list.size());
		assertEquals(20, list.size());
		assertEquals(30, list.size());
	}

	@Test
	public void mockListMethod_get() {
		List list = mock(List.class);
		when(list.get(0)).thenReturn(10);

		assertEquals(10, list.get(0));

		// We have not provided any condition for get(1) so it will always
		// return null
		assertEquals(null, list.get(1));
	}

	/**
	 * anyInt will work on any integer comes in the output will be always
	 * Hargun.
	 * 
	 * similarly anyInt there are multiple other default value return strategy
	 * in mockito.
	 */
	@Test
	public void mockListMethod_get_anyInt() {
		List list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("Hargun");
		assertEquals("Hargun", list.get(0));
		assertEquals("Hargun", list.get(1000));
	}

	@SuppressWarnings("unchecked")
	@Test(expected = RuntimeException.class)
	public void mockListMethod_get_anyInt_exception() {
		List list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenThrow(RuntimeException.class);
		list.get(200);
	}

	/**
	 * Working with BDD, Behaviour F=Driven Development Given, When, Then
	 */
	
	@Test
	public void mockListMethod_get_anyInt_BDD() {
		// Given - Setup kinda things
		/*
		 * When get() of interface List is called with any integer value then
		 * always return Hargun String value
		 */
		List list = mock(List.class);
		given(list.get(Mockito.anyInt())).willReturn("Hargun");

		// When - Call actual system under test
		String value = (String) list.get(0);

		// Then - Verify your result produced
		assertThat("Hargun", is(value));

	}

}
