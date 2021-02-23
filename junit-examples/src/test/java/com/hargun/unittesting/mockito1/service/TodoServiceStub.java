package com.hargun.unittesting.mockito1.service;

import java.util.Arrays;
import java.util.List;

/**
 * @author hargun.suri
 *
 * Implement dummy service implementation behave like that this is
 * external system returning some values when business logic is tested.
 */
public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

}
