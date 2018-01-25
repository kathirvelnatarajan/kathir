package com.kathir.business.impl.stub;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.kathir.business.impl.TodoBusinessImpl;
import com.kathir.data.api.TodoService;
import com.kathir.data.api.stub.TodoServiceStub;

public class TodoBusinessImplTest {

	@Test
	public void test() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
		List<String> filteredTodo = todoBusiness.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(2, filteredTodo.size());
	}

}
