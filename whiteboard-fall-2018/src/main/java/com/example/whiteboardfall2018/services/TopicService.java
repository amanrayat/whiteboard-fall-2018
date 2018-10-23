package com.example.whiteboardfall2018.services;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.whiteboardfall2018.models.Lesson;
import com.example.whiteboardfall2018.models.Topic;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:3000" , allowCredentials = "true" , allowedHeaders = "*")
public class TopicService {
	
	LessonService instance = new LessonService();
	
	@PostMapping("/api/lesson/{lid}/topic")
	public void createTopic(@PathVariable ("lid") int lid, @RequestBody Topic topic , HttpSession session) {
		Lesson lesson = instance.getLessonById(lid , session);
		List<Topic> newTopics = lesson.getTopics();
		newTopics.add(topic);
		lesson.setTopics(newTopics);
	}
	
	@GetMapping("/api/lesson/{lid}/topic")
	public List<Topic> getAllTopicsForLesson(@PathVariable("lid") int lid , HttpSession session){
		return instance.getLessonById(lid , session ).getTopics();
	}
	
	@GetMapping("/api/topic/{tId}")
	public Topic getTopicById(@PathVariable("tId") int tId , HttpSession session) {
		for(Topic topic : this.getAllTopics(session)) {
			System.out.println(topic.getId());
			if(topic.getId() == tId) {
				return topic;
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/topic/{tId}")
	public void deleteTopic(@PathVariable("tId") int tId , HttpSession session) {
		List<Lesson> lessonList = instance.getAllLessons(session);
		for(int i=0;i<lessonList.size();i++) {
			List <Topic> newTopic1 = lessonList.get(i).getTopics();
			List <Topic> newTopic2 = new ArrayList<>();
			for(int j=0;j<newTopic1.size();j++) {
				if(newTopic1.get(j).getId() != tId) {
					newTopic2.add(newTopic1.get(j));
				}
			}
			lessonList.get(i).setTopics(newTopic2);
		}
	}
	
	@GetMapping("/api/topic")
	public List<Topic> getAllTopics(HttpSession session){
		List <Topic> tList = new ArrayList<>();
 		for(Lesson lesson : instance.getAllLessons(session)) {
 			if(lesson.getTopics()!=null) {
 	 			tList.addAll(lesson.getTopics());
 			}
			
		}
 		return tList;
	}
	
	@PutMapping("/api/topic/{lId}")
	public void updateLesson(@PathVariable ("lId") int lId, @RequestBody Topic topic , HttpSession session) {
		if(this.getTopicById(lId , session) ==null)return;
		Topic top = this.getTopicById(lId , session );
		top.setTitle(topic.getTitle()); 
	}
	

}
