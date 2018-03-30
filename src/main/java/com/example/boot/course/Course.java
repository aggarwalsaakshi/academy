package com.example.boot.course;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Course implements Serializable{
	private static final long serialVersionUID = 5945424320655045951L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(
	    name="course_seq",
	    sequenceName="course_sequence",
	    allocationSize=1
	)
	 @Column(name = "courseid")
	private Long courseid;
	@Column(name = "coursename",unique=true)
	private String coursename;
	@Column(name = "fee")
	private Long fee;
	@Column(name = "coursecode", unique = true, nullable = false)
	private String coursecode;
}
