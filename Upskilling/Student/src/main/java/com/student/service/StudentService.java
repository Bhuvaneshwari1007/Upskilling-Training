package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	public List<Student> showAllStudentDetails();
	
	public Student addStudent(Student studentDetails);
	
	public String deleteStudent(long id);

}
