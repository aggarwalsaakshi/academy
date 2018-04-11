package com.example.boot.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot.student.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
