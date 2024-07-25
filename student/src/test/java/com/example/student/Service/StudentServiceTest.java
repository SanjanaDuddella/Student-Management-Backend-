package com.example.student.Service;

import com.example.student.Model.StudentEntity;
import com.example.student.StudentRepo.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {


    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;


    @Test
    void returnOneStudent() throws Exception
    {
        StudentEntity s = new StudentEntity(1L,"Sanju","MIS");
        studentRepository.save(s);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(s));

        assertEquals("Sanju", studentService.getStudentById(1L).getName());
    }

    @Test
    void addStudent()
    {
        StudentEntity s = new StudentEntity(1L,"Sanju","MIS");
        when(studentRepository.save(s)).thenReturn(s);

        assertEquals(studentService.addStudent(s).getName(),"Sanju");
        Mockito.verify(studentRepository, times(1)).save(s);
    }
    @Test
    void returnAllStudents()
    {
        StudentEntity s = new StudentEntity(1L,"Sanju","MIS");
        StudentEntity s1=  new StudentEntity(2L,"Tanny","ITM");
        StudentEntity s2 = new StudentEntity(3L,"Jenny","AI");
        List<StudentEntity> list = new ArrayList<>(Arrays.asList(s,s1,s2));
        when(studentRepository.findAll()).thenReturn(list);

        assertEquals(3, studentService.listOfStudent().size());
    }

    @Test
    void deleteStud() throws  Exception
    {
        StudentEntity s = new StudentEntity(1L,"Sanju","MIS");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(s));
        doNothing().when(studentRepository).deleteById(1L);
        studentService.deleteStudent(1L);

        verify(studentRepository,times(1)).deleteById(1L);

    }
}