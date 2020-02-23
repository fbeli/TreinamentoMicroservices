package com.becb.app.ws.ui.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.becb.app.ws.model.UserRest;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

	//@GetMapping(path="/{userId}") // Path informa que necessita da variável -> localhost:8080/users/98731
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE})
	public UserRest getUser(@PathVariable String userId) {
		UserRest returnRest = new UserRest();
		
		returnRest.setEmail("fred.belis@lugar.co");
		returnRest.setFirstName("Fred");
		returnRest.setLastName("Sousa");
		returnRest.setUserId(userId);
		
		return returnRest;
	}
	
	@GetMapping
	public String getUser(@RequestParam(value="page", defaultValue = "34") int page, 
			@RequestParam(value="limit") int limit) {
		return "get page : "+page+" limit : "+limit;
	}
	
	@PostMapping 
	public String createUser() {
		return "create user";
	}
	
	@PutMapping
	public String updateUser() {
		return "update User";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user";
	}
}
