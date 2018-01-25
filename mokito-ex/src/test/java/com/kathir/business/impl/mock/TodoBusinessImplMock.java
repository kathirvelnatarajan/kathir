package com.kathir.business.impl.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.kathir.business.impl.TodoBusinessImpl;
import com.kathir.data.api.TodoService;

public class TodoBusinessImplMock {

	@Test
	public void test() {
		TodoService todoService = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Interface");
		when(todoService.retrieveTodo("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
		List<String> filteredTodo = todoBusiness.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(2,filteredTodo.size());
	}
	@Test
	public void test2() {
		TodoService todoService = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		when(todoService.retrieveTodo("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
		List<String> filteredTodo = todoBusiness.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(0,filteredTodo.size());
	}

}
