/**
 * 
 */
package com.hargun.unittesting.mockito1.service;

import java.util.List;

/**
 * Basically we are assuming we have service which will communicate with
 * external system and provide us list of data in our business logic to perform
 * operation, lets say this will communicate with WunderList.
 * 
 * @author hargun.suri
 */
public interface TodoService {
	public List<String> retrieveTodos(String user);
}
