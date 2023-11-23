package com.springboot.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {

	@GetMapping("student")
	public ResponseEntity <Student> getStudent() {
		Student student = new Student(1, "Mona", "Shri");
//		return new ResponseEntity<> (student, HttpStatus.OK);
		
		return ResponseEntity.ok()
				.header("custom-header", "ramesh")
				.body(student);
	}
	
	@GetMapping()
	public ResponseEntity <List<Student>> getStudents(){
	List <Student> students = new ArrayList<>();
		students.add(new Student(1,"Mona","Shri"));
		students.add(new Student(2,"Muthu","Krishnan"));
		students.add(new Student(3,"Gayathri","Mani"));
		students.add(new Student(4,"Mani","Maaran"));
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student= new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }
	
	 @GetMapping("query")
	    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
	                                          @RequestParam String firstName,
	                                          @RequestParam String lastName){
	        Student student= new Student(id, firstName, lastName);
	        return ResponseEntity.ok(student);
	    }
	 
	 @PostMapping("create")
	// @ResponseStatus(HttpStatus.CREATED)
	 public ResponseEntity <Student> createStudent(@RequestBody Student student) {
		 System.out.println(student.getId());
		 System.out.println(student.getFirstname());
		 System.out.println(student.getLastname());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("{id}/update")
	 public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		 System.out.println(student.getFirstname());
		 System.out.println(student.getLastname());
		return ResponseEntity.ok(student);
	 }
	 
	 @DeleteMapping("{id}/delete")
	 public ResponseEntity <String> deleteStudent(@PathVariable("id")int studentId) {
		System.out.println(studentId);
		 return ResponseEntity.ok("Student deleted Successfully");
		 
	 }
}
