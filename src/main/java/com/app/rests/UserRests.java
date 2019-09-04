package com.app.rests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.redis.RedisUserRepository;

@RestController
@RequestMapping("/users")
public class UserRests {
	
			@Autowired
	    private RedisUserRepository userRepository;
	 
	@RequestMapping(value="/save",method=RequestMethod.POST,produces="application/json")
	public @ResponseBody User save(@RequestBody User user){
		userRepository.save(user);
		return user;
		
	}
	
	
	@RequestMapping(value="/lists",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody List lists(){
		return userRepository.findAll();
		
	}
}
