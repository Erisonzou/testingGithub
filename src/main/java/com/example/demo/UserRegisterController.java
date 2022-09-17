package com.example.demo;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
		
		@Autowired
		UserRepo repo;
		
		Logger log=Logger.getAnonymousLogger();
		
		@RequestMapping("/register-user/{firstname}/{lastname}/{username}/{password}")
		public String registeration(HttpServletRequest request,HttpServletResponse response,
				@PathVariable("username") String username,
				@PathVariable("password") String password, 
				@PathVariable("firstname") String firstname,
				@PathVariable("lastname") String lastname) 
		{
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setFirstname(firstname);
			user.setLastname(lastname);

			
			log.info("data set");
			
			User ee = repo.save(user);
			
			if (ee!=null) {
				log.info("registration is done");
				return "registration done";
			}else {
				return "something went wrong";
			}
		

		}

	

}
