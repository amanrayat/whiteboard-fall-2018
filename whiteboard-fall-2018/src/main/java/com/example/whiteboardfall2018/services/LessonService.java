package com.example.whiteboardfall2018.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardfall2018.models.Course;
import com.example.whiteboardfall2018.models.Lesson;
import com.example.whiteboardfall2018.models.Module;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class LessonService {
	ModuleService instance = new ModuleService();

	@PostMapping("/api/module/{mid}/lesson")
	public void createLesson(@PathVariable ("mid") int mid, @RequestBody Lesson lesson , HttpSession session) {
			Module module = instance.findModuleById(mid , session);
			List<Lesson> newLessons = module.getLessons();
			newLessons.add(lesson);
			module.setLessons(newLessons);
			
	}
	
	@GetMapping("/api/module/{mid}/lesson")
	public List<Lesson> findAllLessonsForModuleId(@PathVariable("mid") int mId , HttpSession session){
		return instance.findModuleById(mId , session ).getLessons();
	} 
	
	
	@GetMapping("/api/lesson/{lid}")
	public Lesson getLessonById(@PathVariable ("lid") int lid , HttpSession session) {
		List<Module> moduleList = instance.findAllModules(session);
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
	
	@DeleteMapping("/api/lesson/{lid}")
	public void deleteLesson(@PathVariable("lid") int lid , HttpSession session) {
		List<Module> moduleList = instance.findAllModules(session);
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
	
	@GetMapping("/api/lesson")
	public List<Lesson> getAllLessons(HttpSession session){
		List <Lesson> lList = new ArrayList<>();
 		for(Module module : instance.findAllModules(session)) {
 			lList.addAll(module.getLessons());
			
		}
 		return lList;
	}
	
	
	@PutMapping("/api/lesson/{lId}")
	public void updateLesson(@PathVariable ("lId") int lId, @RequestBody Lesson lesson , HttpSession session) {
		if(this.getLessonById(lId , session ) ==null)return;
		Lesson les = this.getLessonById(lId , session );
		les.setTitle(lesson.getTitle()); 
	}
	
}
