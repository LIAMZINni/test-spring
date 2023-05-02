package com.example.demo.repozitory;

import com.example.demo.domen.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



public interface StudentRepozitory extends JpaRepository<Student,Long> {

}
