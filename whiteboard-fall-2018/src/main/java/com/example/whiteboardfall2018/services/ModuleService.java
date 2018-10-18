package com.example.whiteboardfall2018.services;
import com.example.whiteboardfall2018.models.Course;
import com.example.whiteboardfall2018.models.Module;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
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
	
	@PostMapping("api/course/{cid}/module")
	public void createModule(@PathVariable ("cid") int cid, @RequestBody Module module) {
		Course course = instance.findCourseById(cid);
		List<Module> newModuleList  = course.getModule();
		newModuleList.add(module);
		course.setModule(newModuleList);
	}
	
	
	@GetMapping("api/course/{cid}/module")
	public List<Module> getAllModulesForCourse(@PathVariable("cid") int cid){
		Course course = instance.findCourseById(cid);
		return course.getModule();
		
	}
	
	@GetMapping("api/module/{moduleId}")
	public Module findModuleById(@PathVariable ("moduleId") int moduleId){
		List<Course> courseList = instance.findAllCourses();
		for(Course course : courseList) {
			for(Module module : course.getModule()) {
				if(module.getId() == moduleId) {
					return module;
				}
			}
		}
		return null;
	}
	
	@DeleteMapping("api/module/{moduleid}")
	public void deleteModule(@PathVariable("moduleid") int id) {
		
	}
	
	//TODo : Put mapping 

	
}
