package com.example.boot.student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
	public Optional<Student> getStudentDetail(Long id);

	public void setStudentDetail(Student student);
	public List<Student> getAllStudentsDetail();

	public Boolean deleteStudentDetail(Long id);
}
