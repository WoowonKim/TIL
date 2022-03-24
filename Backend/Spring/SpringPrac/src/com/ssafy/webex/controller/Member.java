package com.ssafy.webex.controller;

public class Member {
	private String id;
	private String pass;
	private int age;
	String getId() {
		return id;
	}
	void setId(String name) {
		this.id = name;
	}
	String getPass() {
		return pass;
	}
	void setPass(String pass) {
		this.pass = pass;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [Id=" + id + ", pass=" + pass + ", age=" + age + "]";
	}
}
