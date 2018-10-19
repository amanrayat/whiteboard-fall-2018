package com.example.whiteboardfall2018.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardfall2018.models.Course;
import com.example.whiteboardfall2018.models.Lesson;
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
public class LessonService {
	ModuleService instance = new ModuleService();

	@PostMapping("api/module/{mid}/lesson")
	public void createLesson(@PathVariable ("mid") int mid, @RequestBody Lesson lesson) {
			Module module = instance.findModuleById(mid);
			List<Lesson> newLessons = module.getLessons();
			newLessons.add(lesson);
			module.setLessons(newLessons);
			
	}
	
	@GetMapping("api/module/{mid}/lesson")
	public List<Lesson> findAllLessonsForModuleId(@PathVariable("mid") int mId){
		return instance.findModuleById(mId).getLessons();
	} 
	
	
	@GetMapping("api/lesson/{lid}")
	public Lesson getLessonById(@PathVariable ("lid") int lid) {
		List<Module> moduleList = instance.findAllModules();
		for(Module module : moduleList) {
			Module newModule = module;
			for(Lesson lesson : newModule.getLessons()) {
				if(lesson.getId() == lid) {
					return lesson;
				}
			}
				
		}
		return null;
	
	}
	
	@DeleteMapping("api/lesson/{lid")
	public void deleteLesson(@PathVariable("lid") int lid) {
		List<Module> moduleList = instance.findAllModules();
		for(int i=0;i<moduleList.size();i++) {
			List <Lesson> newLessons1 = moduleList.get(i).getLessons();
			List <Lesson> newLessons2 = new ArrayList<>();
			for(int j=0;j<newLessons1.size();j++) {
				if(newLessons1.get(j).getId() != lid) {
					newLessons2.add(newLessons1.get(j));
				}
			}
			moduleList.get(i).setLessons(newLessons2);
		}
	}
	
	@GetMapping("api/lesson")
	public List<Lesson> getAllLessons(){
		List <Lesson> lList = new ArrayList<>();
 		for(Module module : instance.findAllModules()) {
 			lList.addAll(module.getLessons());
			
		}
 		return lList;
	}
	
}
