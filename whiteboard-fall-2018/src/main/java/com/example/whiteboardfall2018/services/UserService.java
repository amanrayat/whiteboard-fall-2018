package com.example.whiteboardfall2018.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.whiteboardfall2018.models.Person;


//Controller Class 
@RestController
@CrossOrigin(origins = "http://localhost:3000" , allowCredentials = "true" , allowedHeaders = "*")
public class UserService {
	//insitializing the user list with no users in it.
	List<Person> pList = new ArrayList<>();

	@PostMapping("/api/register")
	public Person register(@RequestBody Person person, HttpSession session) {
		pList.add(person);
		System.out.println(session.getId());
		session.setAttribute("currentUser", person);
		return person;
	}


	@GetMapping("/api/profile")
	public Person profile(HttpSession session) {
		Person currentUser = (Person) session.getAttribute("currentUser");
		 return currentUser;
	
	}

	@PostMapping("/api/login")
	public Person login(@RequestBody Person user, HttpSession session) {
		System.out.println(session.getId());
		
		for(Person person : pList) {
			if(person.getUserName().equals(user.getUserName()) && person.getPassword().equals(user.getPassword())) {
				System.out.println(session.getId() );
				session.setAttribute("currentUser", person);
				Person currentUser = (Person) session.getAttribute("currentUser");
				return currentUser;
			}
		}
		return null;
	}

	@GetMapping("/api/logout")
	public String invalidateSession(
			HttpSession session) {
		session.invalidate();
		return "session invalidated";
	}

	@GetMapping("/api/user")
	public List<Person> findAllPersons(@RequestParam (name = "username" , required = false) String username){
		if(username ==null) {
			System.out.println("I am hotting this");
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

	@GetMapping("/api/user/{userId}")
	public Person findUserById(@PathVariable ("userId") int userId){
		for(Person person : pList) {
			if(person.getId() == userId) {
				return person;
			}
		}
		return null;

	}
	@PutMapping("/api/user/{userId}")
	public Person updateUserById(@PathVariable ("userId") int userId , @RequestBody Person user ,   HttpSession session){
		for(Person person : pList) {
			if(person.getId() == userId) {
				person.setEmail(user.getEmail());
				person.setFirstName(user.getFirstName());
				person.setLastName(user.getLastName());
				person.setPhoneNo(user.getPhoneNo());
				session.setAttribute("currentUser", person);
				System.out.println(session.getId());
			}
		}
		return null;

	}


}
