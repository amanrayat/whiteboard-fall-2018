package com.example.whiteboardfall2018.models;

import java.util.Date;
import java.util.List;

public class Course {
	
	public Course(int id, String title, List<Module> module) {
		this.id = id;
		this.title = title;
		this.module = module;
	}
	public Course() {}
	
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
	String title;
	List<Module> module;
	String owner;
	Date created;
	Date modified;
}
