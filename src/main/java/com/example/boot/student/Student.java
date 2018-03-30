package com.example.boot.student;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.boot.course.Course;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Student implements Serializable{
	private static final long serialVersionUID = -7016335500586522991L;
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
@SequenceGenerator(
    name="student_seq",
    sequenceName="student_sequence",
    allocationSize=1
)
@Column(name = "studentid")
private Long id;
@Column(name = "name")
private String name;
@Column(name = "contactNo")
private Long contactNo;
@Column(name = "isMember")
private Boolean isMember;
@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "student_course", joinColumns = { 
		@JoinColumn(name = "studentid", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "courseid", 
				nullable = false, updatable = false) })
private Set<Course> Courses = new HashSet<>();
@Temporal(TemporalType.TIMESTAMP)
@Column(name="joiningDate")
private Date joiningDate;

}
