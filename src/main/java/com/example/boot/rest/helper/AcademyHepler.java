package com.example.boot.rest.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.boot.course.Course;
import com.example.boot.dto.StudentDTO;
import com.example.boot.student.Student;
import com.example.boot.student.StudentService;
@Configuration
public class AcademyHepler {
	
@Autowired
private DozerBeanMapper mapper;
@Autowired
private  StudentService  studentService;
public static final String SUCCESS="SUCCESS";
public static final String RECORD_NOT_EXIST="Record doesn't exist";
	  
	  
public StudentDTO getStudentDetail(Long id) {
	Student student= studentService.getStudentDetail(id).get();
	StudentDTO studentDTO = mapper.map(student, StudentDTO.class);
	 return studentDTO;
	}
		 

public String setStudentDetail(StudentDTO studentDTO) {
	Student student = mapper.map(studentDTO, Student.class);
	 studentService.setStudentDetail(student);
	 return SUCCESS;
}


public List<StudentDTO> getAllStudentsDetail() {
	return studentService.getAllStudentsDetail().stream()
	        .map(student -> mapper.map(student, StudentDTO.class))
	        .collect(Collectors.toList());  
}


public String deleteStudentDetail(Long id) {
	 if(studentService.deleteStudentDetail(id))
	 {
		 return SUCCESS;
	 }
	 return RECORD_NOT_EXIST;	
}


public String getStudentDetail(Long id, StudentDTO studentDTO) {
	Optional<Student> student= Optional.of((Student)studentService.getStudentDetail(id).get());
	 if(student.isPresent()){
			Student existStudent = mapper.map(studentDTO, Student.class);
			existStudent.setId(student.get().getId());
			Course cource =(Course)student.get().getCourses().stream().findFirst().get();
			existStudent.getCourses().stream().findFirst().get().setCourseid(cource.getCourseid());
			 studentService.setStudentDetail(existStudent);
         return SUCCESS;
      }
      return RECORD_NOT_EXIST;
   }
}
