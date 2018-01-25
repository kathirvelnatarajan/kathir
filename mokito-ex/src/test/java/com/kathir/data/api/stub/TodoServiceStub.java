package com.kathir.data.api.stub;

import java.util.Arrays;
import java.util.List;

import com.kathir.data.api.TodoService;

public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodo(String user) {
		
		return Arrays.asList("Learn Spring MVC","Learn Spring", "Learn Mockito");
	}
	

}
