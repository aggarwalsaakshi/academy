package com.example.boot.tutor;

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
public class Faculty implements Serializable{
private static final long serialVersionUID = -4127177380440226509L;
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="faculty_seq")
@SequenceGenerator(
    name="faculty_seq",
    sequenceName="faculty_sequence",
    allocationSize=1)
@Column(name = "id")
private Long id;
@Column(name = "name")
private String name;
@Column(name = "contactNo")
private Long contactNo;
}
