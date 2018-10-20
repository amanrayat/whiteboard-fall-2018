package com.example.whiteboardfall2018.services;
import com.example.whiteboardfall2018.models.Course;
import com.example.whiteboardfall2018.models.Module;

import java.util.ArrayList;
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
	
//	@GetMapping("api/modules")
//	public List<Course> test() {
//		return instance.findAllCourses();
//	}
	
	@PostMapping("api/course/{cid}/module")
	public void createModule(@PathVariable ("cid") int cid, @RequestBody Module module) {
		Course course = instance.findCourseById(cid);
		List<Module> result = new ArrayList<>();
		if(course.getModule()!=null) {
			result.addAll(course.getModule());
		}
		result.add(module);
		course.setModule(result);
	}
	
	
	@GetMapping("api/course/{cid}/module")
	public List<Module> getAllModulesForCourse(@PathVariable("cid") int cid){
		List <Module> result = new ArrayList<>();
		Course course = instance.findCourseById(cid);
		if(course.getModule()!=null) {
			result.addAll(course.getModule());
		}
		return result;
		
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
		List<Course> courseList = instance.findAllCourses();
		for(int i=0;i<courseList.size();i++) {
			List <Module> newModules1 = courseList.get(i).getModule();
			List <Module> newModules2 = new ArrayList<>();
			for(int j=0;j<newModules1.size();j++) {
				if(newModules1.get(j).getId() != id) {
					newModules2.add(newModules1.get(j));
				}
			}
			courseList.get(i).setModule(newModules2);
		}
	}
	
	@GetMapping("api/module")
	public List<Module> findAllModules(){
		List <Module> mList = new ArrayList<>();
 		for(Course course : instance.findAllCourses()) {
 			if(course.getModule()!=null) {
 				mList.addAll(course.getModule());
 			}
			
		}
 		return mList;
	}
	
	@PutMapping("/api/module/{mId}")
	public void updateModule(@PathVariable ("mId") int mId, @RequestBody Module module) {
		if(this.findModuleById(mId) ==null)return;
		Module mod = this.findModuleById(mId);
		mod.setTitle(module.getTitle()); 
	}
	
	//TODo : Put mapping 

	
}
