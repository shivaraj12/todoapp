package com.humesis.todo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String todo;
	
	private byte isDeleted;
	
	private byte isCompleted;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDt;

	public Todo() {
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
