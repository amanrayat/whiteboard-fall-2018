package com.example.whiteboardfall2018.models;

import java.util.List;

public class Module {
	
	public Module() {
	}
	public Module(int id, String title) {
		this.id = id;
		this.title = title;
	}
	int id;
	
	public Module(int id, String title, List<Lesson> lessons) {
		super();
		this.id = id;
		this.title = title;
		this.lessons = lessons;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	String title;
	List <Lesson> lessons;
}
