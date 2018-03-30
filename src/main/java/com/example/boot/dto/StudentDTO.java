package com.example.boot.dto;

import java.util.Date;
import java.util.Set;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {
	private Long id;
	private String name;
	private Long contactNo;
	private Boolean isMember;
	private Set<CourseDTO> Courses;
	private Date joiningDate;
}
