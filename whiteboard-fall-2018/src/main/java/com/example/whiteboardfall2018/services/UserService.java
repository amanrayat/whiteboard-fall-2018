package com.example.whiteboardfall2018.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardfall2018.models.Person;

@RestController
public class UserService {
	List<Person> pList = new ArrayList<>();

	@PostMapping("/api/register")
	public Person register(@RequestBody Person person, HttpSession session) {
		pList.add(person);
		session.setAttribute("currentUser", person);
		return person;
	}

	
	@GetMapping("/api/profile")
	public Person profile(HttpSession session) {
		Person currentUser = (Person) session.getAttribute("currentUser");
		for( Person person :pList) {
			if(person.getId() == currentUser.getId()) return person;
		}
			return null;
	}

}
