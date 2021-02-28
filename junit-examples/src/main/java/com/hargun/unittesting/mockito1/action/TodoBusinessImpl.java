/**
 * 
 */
package com.hargun.unittesting.mockito1.action;

/**
 * This business logic actually communicate with service the service will actually
 * go to third system and bring back us with list of data on which we will perform action
 * 
 * So our this class method TodoBusinessImpl.retrieveTodosRelatedToSpring is actually system under test (SUT).
 * 
 *	So the input will be the the user name and this will communicate to third part via TodoService.retrieveTodos
 * 	and fetch list of To-Do associated with given user after getting the To-Do we will filter out To-Do which belongs
 *  to String.
 * 
 * @author hargun.suri
 */
import java.util.ArrayList;
import java.util.List;

import com.hargun.unittesting.mockito1.service.TodoService;

public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	 
	/*
	 * Anything that is not related to spring we need to delete that from toDo
	 * list.
	 * 
	 */
	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}