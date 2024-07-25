package com.example.student.Controller;

import com.example.student.Model.StudentEntity;
import com.example.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-mgmt")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

@Autowired
StudentService studentService;

@PostMapping("/add")
    private StudentEntity add(@RequestBody StudentEntity student)
{
    return studentService.addStudent(student);
}

@GetMapping("/students")
    private List<StudentEntity> studentList()
{
    return studentService.listOfStudent();
}

@GetMapping("/student/{id}")
private StudentEntity getStudentById(@PathVariable  Long id) throws Exception {
    return studentService.getStudentById(id);
}

@DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable Long id) throws Exception {
        studentService.deleteStudent(id);
    }
}



