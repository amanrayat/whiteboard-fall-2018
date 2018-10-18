package com.example.whiteboardfall2018.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/api/login")
	public Person login(@RequestBody Person user, HttpSession session) {
		for(Person person : pList) {
			if(person.getUserName()==user.getUserName() && person.getPassword() == user.getPassword()) {
				session.setAttribute("currentUser", user);
			}
		}
		return user;
	}

	@GetMapping("/api/logout")
	public String invalidateSession(
			HttpSession session) {
		session.invalidate();
		return "session invalidated";
	}

	@GetMapping("api/user")
	public List<Person> findAllPersons(@RequestParam (name = "username" , required = false) String username){
		if(username !=null) {
			return pList;
		}
		else {
			for(Person person : pList) {
				if(person.getUserName() == username) {

					return (List<Person>) person;
				}
			}
		}
		return null;

	}

	@GetMapping("api/user/{userId}")
	public Person findUserById(@PathVariable ("userId") int userId){
		for(Person person : pList) {
			if(person.getId() == userId) {
				return person;
			}
		}
		return null;

	}


}
