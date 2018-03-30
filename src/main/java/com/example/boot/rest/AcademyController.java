package com.example.boot.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.boot.dto.StudentDTO;
import com.example.boot.rest.helper.AcademyHepler;

@RestController
@RequestMapping(value = "/api")
public class AcademyController {

	 @Autowired
	 private AcademyHepler academyHepler;
	
	 @RequestMapping(value = "/student/{id}",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	 public StudentDTO getStudent(@PathVariable("id") Long id) {
	 return academyHepler.getStudentDetail(id);
	
	 }
	 @RequestMapping(value = "/student",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	 public List<StudentDTO> getAllStudentsDetails() {
	 return academyHepler.getAllStudentsDetail();
	
	 }
	/* @RequestMapping(value = "/student/{id}",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	 public List<Student> updateStudentDetail(@PathVariable("id") Long id) {
	 return academyHepler.getStudentDetail(id);
	
	 }*/
	 @RequestMapping(value = "/health",  method = RequestMethod.GET)
	 public String healthCheck() {
	 return "Welcome Server is UP";
	
	 }	
	 @RequestMapping(value = "/student/{id}",  method = RequestMethod.DELETE)
	 public String deleteStudentDetail(@PathVariable("id") Long id) {
	 
	 return   academyHepler.deleteStudentDetail(id);
	 }
	 
	 
	 @RequestMapping(value = "/student",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	 public String SetStudentDetail(@RequestBody StudentDTO studentDTO) {
		 return	 academyHepler.setStudentDetail(studentDTO);
	
	 }
}
