package com.example.whiteboardfall2018.services;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.whiteboardfall2018.models.Lesson;
import com.example.whiteboardfall2018.models.Topic;
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
public class TopicService {
	
	LessonService instance = new LessonService();
	
	@PostMapping("api/lesson/{lid}/topic")
	public void createTopic(@PathVariable ("lid") int lid, @RequestBody Topic topic) {
		Lesson lesson = instance.getLessonById(lid);
		List<Topic> newTopics = lesson.getTopics();
		newTopics.add(topic);
		lesson.setTopics(newTopics);
	}
	
	@GetMapping("api/lesson/{lid}/topic")
	public List<Topic> getAllTopicsForLesson(@PathVariable("lid") int lid){
		return instance.getLessonById(lid).getTopics();
	}
	
	@GetMapping("api/topic/{tid}")
	public Topic getTopicById(@PathVariable("tId") int tId) {
		List<Lesson> lessonList = instance.getAllLessons();
		for(Lesson lesson : lessonList) {
			Lesson newLesson = lesson;
			for(Topic topic : newLesson.getTopics()) {
				if(topic.getId() == tId) {
					return topic;
				}
			}
				
		}
		return null;
	}
	
	@DeleteMapping("api/topic/{tId}")
	public void deleteTopic(@PathVariable("tId") int tId) {
		List<Lesson> lessonList = instance.getAllLessons();
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
	
	
	
	

}
