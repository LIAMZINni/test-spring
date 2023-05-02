package com.example.demo.servis;

import com.example.demo.domen.Student;
import com.example.demo.repozitory.StudentRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class StudentServis implements IServis<Student>{
    @Autowired
    private final StudentRepozitory studentRepozitory;

    public StudentServis(StudentRepozitory studentRepozitory) {
        this.studentRepozitory = studentRepozitory;
    }

    public List<Student> getAll(){
       return studentRepozitory.findAll();
    }

    public Student save(Student student){
        return studentRepozitory.save(student);

    }
    public Student getById(Long id){
        return studentRepozitory.findById(id).get();
    }
    public Student update(Student student){
        return studentRepozitory.save(student);
    }
    public void deliteStudent(Long id){
        studentRepozitory.deleteById(id);

    }
}
