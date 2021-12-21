package com.ciq.sms.dao;

import java.util.List;

import com.ciq.sms.model.Student;

public interface StudentDao {
	void insert(Student student);
	void update(Student student);
	void delete(int sid);
	Student findById(int sid);
	List< Student>findAll();
	List< Student>findByName(String sname);

	

	
	

}
