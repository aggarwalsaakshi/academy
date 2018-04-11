package com.example.boot.student.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.boot.student.Student;

import com.example.boot.student.StudentService;
import com.example.boot.student.dao.StudentRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Service("studentService")
public class StudentServiceImpl  implements StudentService{
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


