package com.humesis.todo.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humesis.todo.model.Todo;
import com.humesis.todo.repository.TodoRepository;
import com.humesis.todo.request.TodoRequest;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	@Transactional
	public Todo addTodo(TodoRequest todoReqest) {
		
		Todo t = new Todo();
		t.setCreatedDt(new Date());
		t.setIsCompleted((byte) 0);
		t.setIsDeleted((byte) 0);
		t.setTodo(todoReqest.getTodo());
		t.setUpdatedDt(new Date());
		
		t = todoRepository.save(t);
		
		return t;
		
	}
	
	@Transactional
	public Todo getTodoById(int id) {
		
		Todo t = todoRepository.findOne(id);
		
		return t;
	}
	
	@Transactional
	public Todo updateTodo(int id,TodoRequest todoReqest) {
		
		Todo t = todoRepository.findOne(id);
		t.setTodo(todoReqest.getTodo());
		t.setUpdatedDt(new Date());
		
		return t = todoRepository.save(t);
		
	}
	
	@Transactional
	public void deleteTodo(int id) {
		Todo t = todoRepository.findOne(id);
		t.setIsDeleted((byte) 1);
		t.setUpdatedDt(new Date());
		todoRepository.save(t);
	}
	
	@Transactional
	public List<Todo> listAllTodo() {
		List<Todo> t = todoRepository.findAll();
		return t;
	}
	
	@Transactional
	public void completeTodo(int id, byte complete) {
		Todo t = todoRepository.findOne(id);
		t.setIsCompleted(complete);
		t.setUpdatedDt(new Date());
		todoRepository.save(t);
	}
}
