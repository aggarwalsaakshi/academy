package com.example.boot.config;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.boot.dto.StudentDTO;
import com.example.boot.student.Student;

@Configuration
public class DozerConfig {
	@Bean
	public DozerBeanMapper mapper() {
	    DozerBeanMapper mapper = new DozerBeanMapper();
	    mapper.addMapping(beanMappingBuilder());
	    return mapper;
	}
@Bean
public BeanMappingBuilder beanMappingBuilder() {
    return new BeanMappingBuilder() {
        @Override
        protected void configure() {
            mapping(Student.class, StudentDTO.class);
        }
    };
}
}
