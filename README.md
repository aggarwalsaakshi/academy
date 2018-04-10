# academy

* HOW to create a SpringBoot project
1) Open IDE i.e. STS 
2)Go to Menu  File -> new-> SpringBoot-> Spring Starter Project 
build type gradle ->ok


* Configure liquibase
 1) Go to build.gradle
 2) Add dependency
 compile('org.springframework.boot:spring-boot-starter-data-jpa','org.hibernate:hibernate-core')
	runtime('org.liquibase:liquibase-core','com.zaxxer:HikariCP','org.postgresql:postgresql')
	
	By default it search src/main/resourses/db/changelog/db.changelog-master.yaml
	in this  file give path of the file which you want to execute
	like in our example 
	
	databaseChangeLog:
  - include:
      file: db/changelog/versions/2018/1.1/ddl_changelog.yaml
	  
3) Now in ddl_changelog.yaml file add chabgesets
4) Add datasource configuration in application.yml
 spring:
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        current_session_context_class: org.springframework.orm.hibernate5.SpringSessionContext
        dialect: org.hibernate.dialect.PostgreSQL9Dialect
  resources:
    add-mappings: false
  datasource:
    url: jdbc:postgresql://localhost:5433/academy
    username: postgres
    password: post@123
    hikari:
      maximum-pool-size: 20



* REST webservice
 1) Go to build.gradle
 2) Add dependency
 		compile('org.springframework.boot:spring-boot-starter-web-services')
 3) Create java class and add below annoation 
		@RestController
@RequestMapping(value = "/api/rest")

* Add lombok
 1) Go to build.gradle
 2) Add dependency
 compile('org.projectlombok:lombok')
 refresh the dependency
 Go to gradle lombok jat 
 3) Now we can use annotation
 like
@AllArgsConstructor
@Getter
@Setter
@ 
	  
* Add spring security
  1) Go to build.gradle
 2) Add dependency
 	compile('org.springframework.boot:spring-boot-starter-security')
 3) Add changeset for user detail 
 4) Create User entity and UserRepository
 5) Create SecurityConfig.java and extend it with WebSecurityConfigurerAdapter
 override configure methods 
 5) Create service class and extend it with UserDetailsService	and override loadUserByUsername method as in example
 6) create any UserDetails class and extend it with UserDetails and override its methods as in example
 
 Sample request
 
* Insert record
http://localhost:8085/rest/api/student
{
  "name": "nicky",
  "contactNo": 78966778,
  "isMember": true,
  "joiningDate": null,
  "courses": [{
    "coursename": "PHP",
    "fee": 500,
    "coursecode": "PHP"
  }
   ]
}

* Fetch record by ID
http://localhost:8085/rest/api/student/1

* Fetch All records 
http://localhost:8085/rest/api/students