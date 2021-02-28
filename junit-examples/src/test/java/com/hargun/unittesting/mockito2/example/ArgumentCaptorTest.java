/**
 * 
 */
package com.hargun.unittesting.mockito2.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.hargun.unittesting.mockito1.action.TodoBusinessImpl;
import com.hargun.unittesting.mockito1.service.TodoService;

/**
 * @author hargun.suri
 *
 */
public class ArgumentCaptorTest {

	@Test
	public void argumentCaptor_Test() {

		//Argument Captor
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor
				.forClass(String.class);
		
		//Given
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Hargun")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Hargun");
		
		//Then
		/*
		 * Test if the value passed is same we are setting in actual ?
		 */
		Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());
		assertEquals("Learn to Dance", argumentCaptor.getValue());
	}

}
