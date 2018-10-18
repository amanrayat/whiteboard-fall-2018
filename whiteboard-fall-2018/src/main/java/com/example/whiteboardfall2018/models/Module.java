package com.example.whiteboardfall2018.models;

import java.util.List;

public class Module {
	
	public Module() {
	}
	public Module(int id, String moduleName) {
		this.id = id;
		this.moduleName = moduleName;
	}
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	String moduleName;
	List <Lesson> lessons;
}
