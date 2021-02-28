/**
 * 
 */
package com.hargun.unittesting.mockito2.example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.hargun.unittesting.mockito1.action.TodoBusinessImpl;
import com.hargun.unittesting.mockito1.service.TodoService;

/**
 * @author hargun.suri
 *
 */
public class VerifyInterfaceMethodCall {

	@Test
	public void verifyInterfaceMethodCall() {

		/*
		 * Given
		 */

		/*
		 * Create a mock on servic, which methods needs to be verified.
		 */
		TodoService todoService = mock(TodoService.class);

		/*
		 * Create dummy list of allToDos
		 */
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		/*
		 * When retrieveTodos method is called with user "Hargun" return the
		 * above created list this will imitate that an external API is called
		 * and the values are returned but we are actually returning the above
		 * list TodoService -> External API (But we are imitating that and
		 * returning hard-coded list above) when called with particular
		 * parameter.
		 */
		when(todoService.retrieveTodos("Hargun")).thenReturn(allTodos);

		/*
		 * Pass instance of interface into constructor
		 */
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		/*
		 * When
		 * 
		 * Call system under test using some user which shall return list as we
		 * know there are above list of toDo with user hargun.
		 */

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Hargun");

		/*
		 * Then
		 * 
		 * Perform Tests when system under test is completed
		 * 
		 */

		/*
		 * Validate deleteTodo method called or not with below argument?
		 */
		verify(todoService).deleteTodo("Learn to Dance");

		/*
		 * Validate if deleteTodo method is never called with argument
		 * "Learn Spring MVC"
		 */
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

		/*
		 * Validate if deleteTodo method is never called with argument
		 * "Learn Spring"
		 */
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

		/*
		 * Validate if deleteTodo method is called only 1 time with argument
		 * "Learn to Dance"
		 */
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		/*
		 * Similarly we can also verify the method with argument is called
		 * atLeastOnce and atLeast n no of times.
		 * 
		 */
	}
}
