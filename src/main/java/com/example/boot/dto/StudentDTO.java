package com.example.boot.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable {
	private static final long serialVersionUID = -4844864328005315909L;
	private Long id;
	private String name;
	private Long contactNo;
	private Boolean isMember;
	private Set<CourseDTO> courses=new HashSet<>();
	private Date joiningDate;
	
}
