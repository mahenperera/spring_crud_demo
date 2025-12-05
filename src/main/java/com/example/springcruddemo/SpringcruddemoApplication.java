package com.example.springcruddemo;

import com.example.springcruddemo.dao.StudentDAO;
import com.example.springcruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringcruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) { // Inject StudentDAO
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);

            queryForStudentsByLastName(studentDAO);
        };
        
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findByLastName("Garrix");

        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findAll();

        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Sebastian", "Ingrosso", "sebastian@test.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("Nicky", "Romero", "nicky@test.com");
        Student tempStudent2 = new Student("Steve", "Angello", "steve@test.com");
        Student tempStudent3 = new Student("Martin", "Garrix", "martin@test.com");

        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Mahen", "Perera", "mahen@test.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
