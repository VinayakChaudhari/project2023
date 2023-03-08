package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SubjectDto;
import com.app.dto.LoginRequestDto;
import com.app.dto.UserDto;
import com.app.pojos.Course;
import com.app.pojos.Subject;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private JavaMailSender sender;
	
	//authentication for admin
	@PostMapping("/admin/signin")
	public User validateAdmin(@RequestBody LoginRequestDto dto)
	{
		System.out.println("in admin signin "+dto);
		return userService.authenticateAdmin(dto);
	}
	
	//authentication for customer
		@PostMapping("/student/signin")
		public User validateCustomer(@RequestBody LoginRequestDto dto)
		{
			System.out.println("in emp signin "+dto);
			return userService.authenticateCustomer(dto);
		}

	@GetMapping
	public List<User> getAllUsers() {
		System.out.println("in get all student");
		return userService.getAllUsers();
	}
	
	@PostMapping("/customer/saveCustomerdetails")
	public User saveUserDetails(@RequestBody UserDto userDto)
	{
		User user=mapper.map(userDto, User.class);
		
		System.out.println("in save User " + user);// id : null...
		String destEmail = user.getEmail();
		String password=user.getPassword();
		String username=user.getFirstName();
		System.out.println("-----------sending mail-----------");
		System.out.println(" Email "+destEmail);
		SimpleMailMessage mesg = new SimpleMailMessage();
		mesg.setTo(destEmail);
		mesg.setSubject("college managment system ");
		System.out.println("before password is "+password);
		mesg.setText("Oyy "+username +" you have been successfully Registered on college managment system!!!!! \n Your password is "+" :"+password+"\nDiscover the best services \nHave a Good Day!!!!!");
		
		System.out.println("after password is "+password);
		sender.send(mesg);
		
		return userService.saveUserDetails(user);
	}
	
	
	@DeleteMapping("/deletestudent/{stuId}")
	public String deleteCustomer(@PathVariable Long studId)
	{
		return userService.deleteCustomer(studId);
	}
	
	

	
}
