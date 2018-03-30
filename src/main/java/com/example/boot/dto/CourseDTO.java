package com.example.boot.dto;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO implements Serializable {
	private static final long serialVersionUID = -2924048598701791232L;
	private Long courseid;
	private String coursename;
	private Long fee;
	private String coursecode;
}
