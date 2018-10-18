package com.example.whiteboardfall2018.models;

import java.util.Date;
import java.util.List;

public class Course {
	
	public Course(int id, String courseName, List<Module> module) {
		this.id = id;
		this.courseName = courseName;
		this.module = module;
	}
	public Course() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Module> getModule() {
		return module;
	}
	public void setModule(List<Module> module) {
		this.module = module;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	int id ;
	String courseName;
	List<Module> module;
	String owner;
	Date created;
	Date modified;
}
