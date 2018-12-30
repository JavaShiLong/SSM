package com.shilong.dao;

import java.util.List;

import com.shilong.beans.Student;

public interface StudentMapper {
	
	public List<Student> getStuByAge(Student student);
	
	public void updateStu(Student student);
 
}
