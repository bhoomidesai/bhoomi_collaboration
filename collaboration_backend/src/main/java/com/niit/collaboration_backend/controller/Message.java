package com.niit.collaboration_backend.controller;

public class Message {
	private String message ;
	private String fid ;
	private int id ;
	
	

	
	public Message() {
		
	}
	public Message(String message, int id, String fid) {
		
		this.message = message;
		this.id = id;
		this.fid = fid ;
		
	}
	
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("setter id in message class...");
		this.id = id;
	}
}
