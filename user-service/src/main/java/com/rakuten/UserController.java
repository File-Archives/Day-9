package com.rakuten;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation makes a class as a rest controller or a spring controller.
@RequestMapping("/user")
public class UserController {
	
	//Controller is the dependent and service is the dependency.
	//Customer is dependent and shop is the dependency. 
	@Autowired //Tells spring that when this code will run, create an object of user service and assign it to the object service.
	UserService service; // Dependency injection.
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) // will create a status code of 201 for POST which is universally accepted.
	Integer saveUser(@RequestBody User user) {
		System.out.println(String.format("Received Name:: %s, Received Age:: %d", user.getName(), user.getAge()));
		return service.save(user);
	}
	
	@GetMapping
	List<User> getUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping("/name/{name}")
	List<User> getUserFromName(@PathVariable String name) {
		return service.getUserByName(name);
	}
	
	@GetMapping("age/{age}")
	List<User> getUserFromAge(@PathVariable int age) {
		return service.getUserByAge(age);
	}
}
