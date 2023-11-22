package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public List<Student> showAllStudentDetails() {
		List<Student> student = studentRepository.findAll();
		return student;
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.insert(student);
	}

	@Override
	public String deleteStudent(long id) {
		return "Student with the "+id+"Deleted";
	}

}
