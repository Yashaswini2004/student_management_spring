package com.student.student_management.service;
import com.student.student_management.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id,Student student);
    boolean deleteStudent(Long id);
}
