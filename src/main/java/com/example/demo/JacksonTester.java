package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.json.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {
	public static void main(String args[]) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

		// map json to student
		try {
			Student student = mapper.readValue(jsonString, Student.class);
			student.setName("小明");
			student.setArrayS(new String[] {"a","b","c"});
			
			List<Student> lsStudent = new ArrayList<Student>();
			Student s = new Student();
			s.setName("小李");
			s.setAge(55);
			Student ss = new Student();
			ss.setName("小李2");
			ss.setAge(555);
			lsStudent.add(s);
			lsStudent.add(ss);
			student.setLsStudent(lsStudent);

			// mapper.enable(SerializationConfig..Feature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(student);
			System.out.println(jsonString);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
