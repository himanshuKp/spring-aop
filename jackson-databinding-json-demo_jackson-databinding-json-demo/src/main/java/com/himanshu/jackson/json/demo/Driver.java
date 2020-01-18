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
					new File("data/sample-full.json"), Student.class);
			
//			print firstname and lastname
			System.out.println("First name: " +theStudent.getFirstName());
			System.out.println("Last name: " +theStudent.getLastName());

//			print out address: street and city
			Address address = theStudent.getAddress();
			
			System.out.println("Street: " +address.getStreet());
			System.out.println("City: " +address.getCity());
			
//			print out languages
			for (String tempLanguage:theStudent.getLanguages()) {
				System.out.println("Language: " +tempLanguage);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
