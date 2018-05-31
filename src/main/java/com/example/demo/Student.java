package com.example.demo;

import java.util.List;

class Student {
	private String name;
	private int age;
	private String[] arrayS;
	private List<Student> lsStudent;

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Student [ name: " + name + ", age: " + age + " ]";
	}

	public String[] getArrayS() {
		return arrayS;
	}

	public void setArrayS(String[] arrayS) {
		this.arrayS = arrayS;
	}

	public List<Student> getLsStudent() {
		return lsStudent;
	}

	public void setLsStudent(List<Student> lsStudent) {
		this.lsStudent = lsStudent;
	}
}