package com.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.student.controller.StudentController;
import com.student.model.Student;
import com.student.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class StudentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StudentServiceImpl studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = standaloneSetup(studentController).build();
    }

    @Test
    public void testShowAllStudentDetails() throws Exception {
        
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(new Student(1L, "Alice",21, 20000));
        mockStudents.add(new Student(2L, "Bob",22, 40000));

        when(studentService.showAllStudentDetails()).thenReturn(mockStudents);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Alice"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Bob"))
                .andDo(print());
    }

    @Test
    public void testAddStudent() throws Exception {
        Student newStudent = new Student(3L, "Charlie", 19, 21000);

        when(studentService.addStudent(any(Student.class))).thenReturn(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/add")
                .content("{ \"id\": 3, \"name\": \"Charlie\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Charlie"))
                .andDo(print());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        long studentId = 4;

        mockMvc.perform(MockMvcRequestBuilders.delete("/student/delete/{id}", studentId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Deleted Successfully"))
                .andDo(print());
    }
}
