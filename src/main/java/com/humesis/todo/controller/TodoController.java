package com.humesis.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.humesis.todo.model.Todo;
import com.humesis.todo.request.TodoRequest;
import com.humesis.todo.service.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public ResponseEntity<?> getTodoList(){

		return new ResponseEntity<>(todoService.listAllTodo(),HttpStatus.OK) ;
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTodoById(@PathVariable int id){
		return new ResponseEntity<>(todoService.getTodoById(id),HttpStatus.OK) ;
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public ResponseEntity<Todo> createTodo(@RequestBody TodoRequest todoRequest){
		return new ResponseEntity<Todo>(todoService.addTodo(todoRequest),HttpStatus.OK) ;
	}
	
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTodo(@RequestBody TodoRequest todoRequest,@PathVariable int id){
		return new ResponseEntity<>(todoService.updateTodo(id, todoRequest),HttpStatus.OK) ;
	}

	/*@RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTodo(@PathVariable int id){
		todoService.deleteTodo(id);
		return new ResponseEntity<>(HttpStatus.OK) ;
	}*/

	@RequestMapping(value = "/todo/{id}/status", method = RequestMethod.PUT)
	public ResponseEntity<?> changeTodoStatus(@PathVariable int id, 
			@RequestParam(value = "complete",required=true, defaultValue="0") boolean complete){
		
		byte  status = (byte)(complete ? 1:0);
		todoService.completeTodo(id, status);
		return new ResponseEntity<>(HttpStatus.OK) ;
	}


}
