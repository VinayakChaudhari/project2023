package com.app.controller;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CartItemDto;

import com.app.dto.LoginRequestDto;
import com.app.dto.UserDto;
import com.app.pojos.CartItem;
import com.app.pojos.User;
import com.app.service.CartItemService;
import com.app.service.StudentService;

@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customers")
public class StudentController {

	@Autowired
	private StudentService custService;

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private JavaMailSender sender;

	@Autowired
	private CartItemService cartItemService;

	// authentication for customer
	@PostMapping("/customer/signin")
	public User validateCustomer(@RequestBody LoginRequestDto dto) {
		System.out.println("in emp signin " + dto);
		return custService.authenticateCustomer(dto);
	}

	@PostMapping("/customer/saveCustomerdetails")
	public User saveUserDetails(@RequestBody UserDto userDto) {
		User user = mapper.map(userDto, User.class);

		System.out.println("in save User " + user);// id : null...
		String destEmail = user.getEmail();
		String password = user.getPassword();
		String username = user.getFirstName();
		System.out.println("-----------sending mail-----------");
		System.out.println(" Email " + destEmail);
		SimpleMailMessage mesg = new SimpleMailMessage();
		mesg.setTo(destEmail);
		mesg.setSubject("Highway Help Project");
		System.out.println("before password is " + password);
		mesg.setText("Oyy " + username
				+ " you have been successfully Registered on Highway Help Platform !!!!! \n Your password is " + " :"
				+ password + "\nDiscover the best services \nHave a Good Day!!!!!");
		System.out.println("after password is " + password);
		sender.send(mesg);
		return custService.saveUserDetails(user);
	}

	@PostMapping("/addCartItem")
	public String addCartItem(@RequestBody CartItemDto newCartItem) {
		System.out.println("inside customer controller !!");
		return cartItemService.addCartItem(newCartItem);
	}

	// if forgot password

	@PostMapping("/forgetPassword")
	public ResponseEntity<?> forgetUserPassword(@RequestBody LoginRequestDto dto) {

		try {
			System.out.println(dto);
			User validateuser = custService.forgetPassword(dto);
			System.out.println(validateuser);

			String destEmail = validateuser.getEmail();
			String password = validateuser.getPassword();
			String username = validateuser.getFirstName();
			System.out.println("-----------sending mail-----------");
			System.out.println(" Email " + destEmail);
			SimpleMailMessage mesg = new SimpleMailMessage();
			mesg.setTo(destEmail);
			mesg.setSubject("HighwayHelp Forget password");
			mesg.setText("Hi " + username + " Your password is " + ": " + password
					+ "\nPlease Try again For Login!!!!!!!!!!");
			sender.send(mesg);

			return new ResponseEntity<>(validateuser, HttpStatus.OK);
		} catch (Exception e) {
			ResourceNotFoundException resp = new ResourceNotFoundException("Enter Valid Email id");
			return new ResponseEntity<>(resp, HttpStatus.CONFLICT);
		}
	}

}
