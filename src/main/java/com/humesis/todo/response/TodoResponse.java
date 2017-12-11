package com.humesis.todo.response;

import java.util.Date;


public class TodoResponse {
	
	private int id;
	private String todo;
	private byte isDeleted;
	private byte isCompleted;
	private Date updatedDt;
	private Date createdDt;
	
	public TodoResponse() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public byte getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(byte isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	
	
	
}
