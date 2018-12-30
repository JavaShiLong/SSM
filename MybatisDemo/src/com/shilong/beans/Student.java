package com.shilong.beans;

import java.util.Date;

public class Student {

	private Integer id;
	private String name;
	private double score;
	private Date birth;
	private int age;

	public Student(Integer id, String name, double score, Date birth, int age) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.birth = birth;
		this.age = age;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + ", birth=" + birth + ", age=" + age + "]";
	}

}
