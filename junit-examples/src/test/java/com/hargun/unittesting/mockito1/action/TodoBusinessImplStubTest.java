/**
 * 
 */
package com.hargun.unittesting.mockito1.action;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hargun.unittesting.mockito1.service.TodoService;
import com.hargun.unittesting.mockito1.service.TodoServiceStub;

/**
 * @author hargun.suri
 * 
 *         This class is used to test methods of TodoBusinessImpl.
 * 
 *
 */
@RunWith(Parameterized.class)
public class TodoBusinessImplStubTest {

	private static TodoBusinessImpl todoBusinessImpl;
	private String inputValue;

	public TodoBusinessImplStubTest(String inputValue) {
		super();
		this.inputValue = inputValue;
	}

	@BeforeClass
	public static void initializeVariables() {
		TodoService todoService = new TodoServiceStub();
		todoBusinessImpl = new TodoBusinessImpl(todoService);
	}

	@Parameters
	public static List<String> inputParams() {
		String[] inputValues = { "Learn Spring MVC", "Learn Spring", "" };
		return Arrays.asList(inputValues);
	}

	/**
	 * Validate if the value return from the stub is valid and returning some
	 * data.
	 */
	@Test
	public void retrieveTodosRelatedToSpring_testStub() {
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		assertEquals(2, todos.size());
	}

	/**
	 * Validate if the passed input present in the ToDo return by our business
	 * logic or not.
	 */
	@Test
	public void retrieveTodosRelatedToSpring_validateSetOfValues() {
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		assertTrue(todos.contains(inputValue));
	}

	/***
	 * Need to check if we pass parameters, then the execution will execute all
	 * methods marked with @Test for no of time we have parameters in it one by
	 * one so in our case both method are executed with each value once
	 */

}
