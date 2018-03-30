package com.example.boot.rest.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.boot.dto.StudentDTO;
import com.example.boot.student.Student;
import com.example.boot.student.StudentService;
@Configuration
public class AcademyHepler {
	  @Autowired
	   private DozerBeanMapper mapper;
	  @Autowired
	private  StudentService  studentService;
	  
	  
public StudentDTO getStudentDetail(Long id) {
	Student student= studentService.getStudentDetail(id).get();
	StudentDTO studentDTO = mapper.map(student, StudentDTO.class);
	 return studentDTO;
	}
		 

public String setStudentDetail(StudentDTO studentDTO) {
	Student student = mapper.map(studentDTO, Student.class);
	 studentService.setStudentDetail(student);
	 return "Sucess";
}


public List<StudentDTO> getAllStudentsDetail() {
	return studentService.getAllStudentsDetail().stream()
	        .map(student -> mapper.map(student, StudentDTO.class))
	        .collect(Collectors.toList());  
}


public String deleteStudentDetail(Long id) {
	 if(studentService.deleteStudentDetail(id))
	 {return "Sucess";}
	 else
	 {return "Id doesn't exist";}
	
}

}
