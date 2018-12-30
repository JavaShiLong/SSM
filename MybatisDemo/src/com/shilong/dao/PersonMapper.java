package com.shilong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shilong.beans.Person;

public interface PersonMapper {

	public void add(Person person);

	public void delete(Integer id);

	public void update(Person person);

	public Person getPersonById(Integer id);

	public List<Person> getAllPerson();
	
	public void deleteByTwo(@Param("id")Integer id,@Param("age")int age);

}
