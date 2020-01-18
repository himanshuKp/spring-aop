package com.himanshu.springdemo.restService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.springdemo.config.Student;

@RestController
@RequestMapping("/api")
public class StudentService {

//	student mapping to get list of students
	@GetMapping("/students")
	public List<Student> listStudents(){
		List<Student> theStudent = new ArrayList<Student>();
		
		theStudent.add(new Student("R","Kandpal"));
		theStudent.add(new Student("D","Joshi"));
		theStudent.add(new Student("H","Kandpal"));
		
		return theStudent;
		
	}
}
