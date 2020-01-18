package com.himanshu.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
//			create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
//			read json file and map/convert to java pojo
//			data/sample-lite.json
			Student theStudent = mapper.readValue(
					new File("data/sample-lite.json"), Student.class);
			
//			print firstname and lastname
			System.out.println("First name: " +theStudent.getFirstName());
			System.out.println("Last name: " +theStudent.getLastName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
