package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SubjectDto;
import com.app.dto.SubjectDtoToUpdate;
import com.app.pojos.Subject;
import com.app.service.SubjectService;

@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
public class SubjectController {

	@Autowired
	private SubjectService subService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping("/addProduct/{courseId}")
	public Subject addHospital(@PathVariable Long categoryId, @RequestBody SubjectDto newHospital) {
		Subject newProduct = mapper.map(newHospital, Subject.class);

		return subService.addHospital(categoryId, newProduct);
	}

	@DeleteMapping("/deleteProduct/{subjectId}")
	public String deleteHospital(@PathVariable Long productId) {
		return subService.deleteHospital(productId);
	}

	@GetMapping("/getAllProducts/{courseId}")
	public List<Subject> getAllProducts(@PathVariable Long courseId) {
		return subService.getAllSubject(courseId);
	}

	@PutMapping("/updateSubject")
	public Subject updateProduct(@RequestBody SubjectDtoToUpdate detachedProduct) {

		return subService.updateProduct(detachedProduct);
	}

}
