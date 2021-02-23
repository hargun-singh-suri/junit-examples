/**
 * 
 */
package com.hargun.unittesting.mockito1.action;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.hargun.unittesting.mockito1.service.TodoService;

/**
 * @author hargun.suri
 *
 *         Instead of using STUB for the service instance we will use Mockito
 */
public class TodoBusinessImplMockitoTest {

	/**
	 * Validate if the value return from the mock is valid and returning some
	 * data.
	 */
	@Test
	public void retrieveTodosRelatedToSpring_testMock() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		/*
		 * When retrieveTodos method is called on instance created from the mock
		 * the return list of values define.
		 * 
		 * Now we can create different method with different values.
		 */
		when(todoService.retrieveTodos("Spring")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		/*
		 * If the value here is different say Dummy then empty list will be
		 * return as we have defined above we need list on Spring but did not
		 * defined any list on Dummy
		 */
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		assertEquals(2, todos.size());
	}

}
