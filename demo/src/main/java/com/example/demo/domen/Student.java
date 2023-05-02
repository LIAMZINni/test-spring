package com.example.demo.domen;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")

@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "emale")
    private String emale;

    public Student() {

    }

    public Student(String name, Integer age, String emale) {
        this.name = name;
        this.age = age;

        this.emale = emale;
    }


    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +

                ", emale='" + emale + '\'' +
                '}';
    }
}
