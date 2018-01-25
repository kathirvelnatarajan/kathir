package com.kathir.business.impl;

import java.util.ArrayList;
import java.util.List;

import com.kathir.data.api.TodoService;

public class TodoBusinessImpl {
	private TodoService todoService;
	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	public List<String> retrieveTodoRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodo(user);
		for(String todo: todos) {
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

}
