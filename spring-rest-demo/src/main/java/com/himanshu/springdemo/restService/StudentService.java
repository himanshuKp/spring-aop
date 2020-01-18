package com.himanshu.springdemo.restService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.springdemo.config.Student;

@RestController
@RequestMapping("/api")
public class StudentService {

	private List<Student> theStudent;	
	
	@PostConstruct
	public void loadData() {
		theStudent = new ArrayList<>();
		theStudent.add(new Student("R","Kandpal"));
		theStudent.add(new Student("D","Joshi"));
		theStudent.add(new Student("H","Kandpal"));
	}
	
//	student mapping to get list of students
	@GetMapping("/students")
	public List<Student> listStudents(){
		return theStudent;
	}
	
//	define endpoint for /student/{studentID}
	@GetMapping("/students/{studentId}")
	public Student loadStudentId(@PathVariable int studentId){
		return theStudent.get(studentId);
	}
}
