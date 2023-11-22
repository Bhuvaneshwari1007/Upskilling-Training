package com.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowAllStudentDetails() {
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(new Student(1L, "Kiran", 19, 20000));
        mockStudents.add(new Student(2L, "Karan", 20, 15000));

        when(studentRepository.findAll()).thenReturn(mockStudents);

        List<Student> result = studentService.showAllStudentDetails();

        verify(studentRepository, times(1)).findAll();

        assertEquals(2, result.size());
        assertEquals("Kiran", result.get(0).getName());
        assertEquals("Karan", result.get(1).getName());
    }

    @Test
    public void testAddStudent() {
        Student newStudent = new Student(3L, "Maran", 21,18000);

        when(studentRepository.insert(any(Student.class))).thenReturn(newStudent);

        Student result = studentService.addStudent(newStudent);

        verify(studentRepository, times(1)).insert(any(Student.class));

        assertEquals(3, result.getId());
        assertEquals("Maran", result.getName());
    }

    @Test
    public void testDeleteStudent() {
        long studentId = 4;

        String result = studentService.deleteStudent(studentId);

        assertEquals("Student with the 4Deleted", result);
    }
}

