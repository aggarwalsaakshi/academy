# academy

* HOW to create a SpringBoot project
1) Open IDE i.e. STS 
2)Go to Menu  File -> new-> SpringBoot-> Spring Starter Project 
 Give name of the project, build type gradle ->ok

* How to change local IP to domain name so a host can access a VM?
1) Put an entry in Windows 7 hosts file.
c:\\Windows\System32\Drivers\etc\hosts
	127.0.0.1       academy.com
	
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
 3) Go to lombok jar right click and click on Run As-> Java application (give path on you IDE) and click on install/update it.
 
 3) Now we can use annotation
 like
@AllArgsConstructor
@Getter
@Setter
	  
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
 


* Sample requests
 username :api_user
 Password: Password1
* Insert a record
http://academy.com:8085/rest/api/student
method: POST
Payload:

{
  "name": "nicky",
  "contactNo": 78966778,
  "isMember": true,
  "courses": [{
    "coursename": "PHP",
    "fee": 500,
    "coursecode": "PHP"
  }
   ]
}

* Fetch record by studentid
http://academy.com:8085/rest/api/student/1
method: GET

* Fetch All records 
http://academy.com:8085/rest/api/students
method: GET

* Delete record by studentid 
http://academy.com:8085/rest/api/student/1
method: DELETE

* update record by studentid 
http://academy.com:8085/rest/api/student/1
method: PUT
Payload:

{
  "name": "nicky",
  "contactNo": 78966778,
  "isMember": true,
  "courses": [{
    "coursename": "PHP",
    "fee": 500,
    "coursecode": "PHP"
  }
   ]
}


Important link
https://stackoverflow.com/questions/8716259/what-does-the-apr-based-apache-tomcat-native-library-was-not-found-mean