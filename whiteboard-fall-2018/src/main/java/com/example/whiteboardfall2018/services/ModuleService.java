package com.example.whiteboardfall2018.services;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardfall2018.models.Course;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class ModuleService {
	
	CourseService instance = new CourseService();
	
	@GetMapping("api/modules")
	public List<Course> test() {
		return instance.findAllCourses();
	}

	
}
