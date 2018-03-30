package com.example.boot.student.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.dto.StudentDTO;
import com.example.boot.student.Student;
import com.example.boot.student.StudentRepository;
import com.example.boot.student.StudentService;
@Service("studentService")
public class StudentServiceImpl  implements StudentService{
@Autowired
private DozerBeanMapper mapper;
@Autowired
private StudentRepository studentRepository;

public Optional<Student> getStudentDetail(Long id)
{
	return studentRepository.findById(id);
}

public void setStudentDetail(Student student)
{
	 studentRepository.save(student);
}

public List<Student> getAllStudentsDetail() {
	    return studentRepository.findAll();
	}

@Override
public Boolean deleteStudentDetail(Long id) {
	 Optional<Student> student= studentRepository.findById(id);
	if(student.isPresent())
	{
		studentRepository.deleteById(id);
		return true;
	}
	return false;
}
}


