package com.example.boot.rest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.boot.dto.StudentDTO;
import com.example.boot.rest.helper.AcademyHepler;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping(value = "/rest/api")
public class AcademyController {

	 @Autowired
	 private AcademyHepler academyHepler;
	
	 @RequestMapping(value = "/student/{id}",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	 public StudentDTO getStudent(@PathVariable("id") Long id) {
	 return academyHepler.getStudentDetail(id);
	
	 }
	 @RequestMapping(value = "/students",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	 public List<StudentDTO> getAllStudentsDetails() {
	 return academyHepler.getAllStudentsDetail();
	
	 }
	 @RequestMapping(value = "/student/{id}",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	 public String updateStudentDetail(@PathVariable("id") Long id,@RequestBody StudentDTO studentDTO) {
	 return academyHepler.getStudentDetail(id,studentDTO);
	
	 }
	 @RequestMapping(value = "/health",  method = RequestMethod.GET)
	 public String healthCheck() {
	 return "Welcome Server is UP";
	
	 }	
	 @RequestMapping(value = "/student/{id}",  method = RequestMethod.DELETE)
	 public String deleteStudentDetail(@PathVariable("id") Long id) {
	 
	 return   academyHepler.deleteStudentDetail(id);
	 }
	 
	 
	 @RequestMapping(value = "/student",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	 public Map<String, String>  SetStudentDetail(@RequestBody StudentDTO studentDTO) {
	 studentDTO.setJoiningDate(new Date());
	 Map<String, String> status= new HashMap<>(1);
     status.put("status",academyHepler.setStudentDetail(studentDTO));
		 return status ;
	
	 }
	 
	 @ExceptionHandler(Exception.class)
	    public Map<String, String> academyException(Exception exception) {
	        log.error("AcademyController::academyException: ", exception);
	        Map<String, String> status= new HashMap<>(1);
	        status.put("status", "ERROR");
	        return status; 
	 }
}
