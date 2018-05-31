package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Demo implements Serializable{

	private static final long serialVersionUID = 8079166818777210582L;
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;// 主键.
	
	@Column(nullable = false)
	private String name;// 测试名称.
	
	public Demo() {
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
