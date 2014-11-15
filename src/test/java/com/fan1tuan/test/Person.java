package com.fan1tuan.test;

import java.lang.*;

public class Person {
	private String id;
	private String name;
	private int age;
	private int sex;
	
	private java.lang.Character[] characters;
	//private Comment[] comments;
	
	
	
	public String getId() {
		return id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public void setId(String id) {
		this.id = id;
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
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
		
	public java.lang.Character[] getCharacters() {
		return characters;
	}
	public void setCharacters(java.lang.Character[] characters) {
		this.characters = characters;
	}
	public Person() {}
	
	@Override
	public String toString(){
		return "Person [id="+id+", name="+name+", age="+age+", characters="+characters.toString()+"]";
	}
}
