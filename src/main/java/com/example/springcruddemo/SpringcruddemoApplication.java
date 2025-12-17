package com.example.springcruddemo;

import com.example.springcruddemo.dao.InstructorDAO;
import com.example.springcruddemo.dao.StudentDAO;
import com.example.springcruddemo.entity.Course;
import com.example.springcruddemo.entity.Instructor;
import com.example.springcruddemo.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) { // Inject StudentDAO
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);

//            createInstructor(instructorDAO);
//            findInstructor(instructorDAO);
//            deleteInstructor(instructorDAO);
//            findInstructorDetail(instructorDAO);
//            deleteInstructorDetail(instructorDAO);
//            createInstructorWithCourses(instructorDAO);
//            findInstructorWithCourses(instructorDAO);
//            findCoursesForInstructor(instructorDAO);
//            findInstructorWithCoursesJoinFetch(instructorDAO);
//            updateInstructor(instructorDAO);
//            updateCourse(instructorDAO);
//            deleteInstructor(instructorDAO);
            deleteCourse(instructorDAO);
        };
    }

    private void deleteCourse(InstructorDAO instructorDAO) {

        int theId = 10;
        System.out.println("Deleting course id: " + theId);
        instructorDAO.deleteCourseById(theId);
    }

    private void updateCourse(InstructorDAO instructorDAO) {

        int theId = 10;
        System.out.println("Finding course id: " + theId);
        Course tempCourse = instructorDAO.findCourseById(theId);

        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("Progressive House - The Complete Guide");

        instructorDAO.update(tempCourse);
    }

    private void updateInstructor(InstructorDAO instructorDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = instructorDAO.findInstructorById(theId);

        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("Ingrosso");

        instructorDAO.update(tempInstructor);
    }

    private void findInstructorWithCoursesJoinFetch(InstructorDAO instructorDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = instructorDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("Instructor: " + tempInstructor);
        System.out.println("Courses: " + tempInstructor.getCourses());
    }

    private void findCoursesForInstructor(InstructorDAO instructorDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = instructorDAO.findInstructorById(theId);

        System.out.println("Instructor: " + tempInstructor);

        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = instructorDAO.findCoursesByInstructorId(theId);

        tempInstructor.setCourses(courses);

        System.out.println("Courses: " + tempInstructor.getCourses());
    }

    private void findInstructorWithCourses(InstructorDAO instructorDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = instructorDAO.findInstructorById(theId);

        System.out.println("Instructor: " + tempInstructor);
        System.out.println("Courses: " + tempInstructor.getCourses());
    }

    private void createInstructorWithCourses(InstructorDAO instructorDAO) {

        Instructor tempInstructor = new Instructor("Steve", "Angello", "steve@test.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/steve", "EDM");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Progressive House - The Basics");
        Course tempCourse2 = new Course("Afro House - The Full Guide");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("Courses: " + tempInstructor.getCourses());
        instructorDAO.save(tempInstructor);
    }

    private void deleteInstructorDetail(InstructorDAO instructorDAO) {

        int theId = 3;
        System.out.println("Deleting instructor detail: " + theId);

        instructorDAO.deleteInstructorDetailById(theId);
    }

    private void findInstructorDetail(InstructorDAO instructorDAO) {

        int theId = 2;
        InstructorDetail tempInstructorDetail = instructorDAO.findInstructorDetailById(theId);

        System.out.println("Instructor Detail: " + tempInstructorDetail);
        System.out.println("Instructor: " + tempInstructorDetail.getInstructor());
    }

    private void deleteInstructor(InstructorDAO instructorDAO) {

        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        instructorDAO.deleteInstructorById(theId);
    }

    private void findInstructor(InstructorDAO instructorDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = instructorDAO.findInstructorById(theId);

        System.out.println("Instructor: " + tempInstructor);
        System.out.println("Instructor Detail: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(InstructorDAO instructorDAO) {

        Instructor tempInstructor = new Instructor("Martin", "Garrix", "martin@test.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/martin", "EDM");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);
        instructorDAO.save(tempInstructor);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students ...");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 5;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {

        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        System.out.println("Updating student ...");
        myStudent.setFirstName("Abisheka");

        studentDAO.update(myStudent);

        System.out.println("Updated student: " + myStudent);
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
