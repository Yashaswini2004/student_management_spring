package com.student.student_management.controller;
import com.student.student_management.model.Student;
import com.student.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentRepository.findById(id).orElse(null);
    }
    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student updatedStudent){
        return studentRepository.findById(id).map(student->{
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
           return studentRepository.save(student);
        }).orElse(null);
    }
    @DeleteMapping
    public String deleteStudent(@PathVariable Long id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "Student deleted successfullyy!!";
        }
        else {
            return "Student not found";
        }
    }
}
