package com.example.student.Service;

import com.example.student.Model.StudentEntity;
import com.example.student.StudentRepo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    public StudentEntity addStudent(StudentEntity student)
    {
        return studentRepository.save(student);
    }

    public List<StudentEntity> listOfStudent()
    {
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Long id) throws Exception {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if(student.isEmpty())
        {
            throw new Exception("No Student present with this ID");
        }
        else
        {
            return student.get();
        }
    }

    public void deleteStudent(Long id) throws Exception {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if(optional.isEmpty())
        {
            throw new Exception("No student found with this id");
        }
        else
        {
            studentRepository.deleteById(id);
        }
    }



}
