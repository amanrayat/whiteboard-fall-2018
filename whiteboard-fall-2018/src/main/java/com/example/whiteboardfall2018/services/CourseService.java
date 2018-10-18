package com.example.whiteboardfall2018.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardfall2018.models.Course;

@RestController
@CrossOrigin
public class CourseService {

	public static List<Course> cList = new ArrayList<>();
	
	private static CourseService instance = null;
	
	private CourseService(List<Course> cList) {
		CourseService.cList = cList;
	}
	CourseService(){}
	
	public static CourseService getInstance() {
		if(instance ==null) {
			instance = new CourseService(cList);
		}
		return instance;
	}

	
	@GetMapping("/api/course")
	public List<Course> findAllCourses(){
		return cList; 
	}

	@GetMapping("api/course/{courseId}")
	public Course findCourseById(@PathVariable ("courseId") int courseId){
		for(Course course : cList) {
			if(course.getId() == courseId) {
				return course;
			}

		}
		return null;

	}	
	@DeleteMapping("api/course/{courseid}")
	public void deleteCourse(@PathVariable("courseid") int id) {
		for(int i=0;i<cList.size();i++) {
			if(cList.get(i).getId()==id) {
				cList.remove(i);
			}
		}

	}

	@PostMapping("api/course")
	public void createCourse(@RequestBody Course course) {
		cList.add(course);
	}

	@PutMapping("api/course")
	public void updateCourse(@PathVariable("courseId") int id , @RequestBody Course course) {
		Course newCourse = new Course();		
		for(Course course1 : cList) {
			if(course1.getId() == id) {
				newCourse =  course1;
			}

		}
		newCourse.setOwner(course.getOwner());
		newCourse.setCourseName(course.getCourseName());
		
	}


}
