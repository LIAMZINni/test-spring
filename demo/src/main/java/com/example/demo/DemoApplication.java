package com.example.demo;

import com.example.demo.domen.Student;
import com.example.demo.repozitory.StudentRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private  StudentRepozitory studentRepozitory;


	@Override
	public void run(String... args) throws Exception {




	}
}
