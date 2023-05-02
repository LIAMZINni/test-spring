package com.example.demo.controller;

import com.example.demo.servis.StudentServis;
import com.example.demo.domen.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class StudentController {

    private final StudentServis studentServis;
    @Autowired
    public StudentController(StudentServis studentServis) {
        this.studentServis=studentServis;
    }


    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students",studentServis.getAll());
        return "students";

    }
    @GetMapping("/students/new")
    public String addStudents(Model model){
        Student student =new Student();
        model.addAttribute("student",student);
        return "add_student";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentServis.save(student);
        return "redirect:/students";


    }
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id,Model model){
        model.addAttribute("student",studentServis.getById(id));
        return "update_student";

    }
    @PostMapping("/students/{id}")
    public String updateStudents(@PathVariable Long id,@ModelAttribute("student")  Student student,Model model){
        Student student1=studentServis.getById(id);
        student1.setId(id);
        student1.setAge(student.getAge());
        student1.setEmale(student.getEmale());
        student1.setName(student.getName());
        studentServis.update(student1);
        return "redirect:/students";

    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentServis.deliteStudent(id);
        return "redirect:/students";


    }
    @GetMapping("/test")
    public String toString() {
        return "test";
    }
}
