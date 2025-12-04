package com.example.springcruddemo;

import com.example.springcruddemo.dao.StudentDAO;
import com.example.springcruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) { // Inject StudentDAO
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Mahen", "Perera", "mahen@test.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
