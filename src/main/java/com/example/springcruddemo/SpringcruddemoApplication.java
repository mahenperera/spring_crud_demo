package com.example.springcruddemo;

import com.example.springcruddemo.dao.CourseDAO;
import com.example.springcruddemo.dao.InstructorDAO;
import com.example.springcruddemo.dao.StudentDAO;
import com.example.springcruddemo.entity.*;
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
    public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO, CourseDAO courseDAO, StudentDAO studentDAO) {
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
//            updateCourse(courseDAO);
//            deleteInstructor(instructorDAO);
//            deleteCourse(courseDAO);

//            createCourseAndReviews(courseDAO);
//            retrieveCourseAndReviews(courseDAO);
//            deleteCourseAndReviews(courseDAO);

//            createCourseAndStudents(courseDAO);
//            findCourseAndStudents(courseDAO);
//            findStudentAndCourses(studentDAO);
//            addMoreCoursesForStudent(studentDAO);
//            deleteCourse(courseDAO);
            deleteStudent(studentDAO);
        };
    }

    private void addMoreCoursesForStudent(StudentDAO studentDAO) {

        int theId = 2;
        Student tempStudent = studentDAO.findStudentAndCoursesByStudentId(theId);

        Course tempCourse1 = new Course("The Mixing Master - Ultimate Plugin Guide");
        Course tempCourse2 = new Course("House Music Guide");

        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        System.out.println("Updating student: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());

        studentDAO.update(tempStudent);
    }

    private void findStudentAndCourses(StudentDAO studentDAO) {

        int theId = 2;
        Student tempStudent = studentDAO.findStudentAndCoursesByStudentId(theId);

        System.out.println("Student: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());
    }

    private void findCourseAndStudents(CourseDAO courseDAO) {

        int theId = 10;
        Course tempCourse = courseDAO.findCourseAndStudentsByCourseId(theId);

        System.out.println("Course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());
    }

    private void createCourseAndStudents(CourseDAO courseDAO) {

        Course tempCourse = new Course("Melodic Rave - Beginners Guide");

        Student tempStudent1 = new Student("Mahen", "Perera", "mahen@test.com");
        Student tempStudent2 = new Student("Martin", "Garrix", "martin@test.com");
        Student tempStudent3 = new Student("Sebastian", "Ingrosso", "sebastian@test.com");

        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
        tempCourse.addStudent(tempStudent3);

        System.out.println("Saving the course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());

        courseDAO.save(tempCourse);
    }

    private void deleteCourseAndReviews(CourseDAO courseDAO) {

        int theId = 10;
        System.out.println("Deleting course id: " + theId);
        courseDAO.deleteCourseById(theId);
    }

    private void retrieveCourseAndReviews(CourseDAO courseDAO) {

        int theId = 10;
        Course tempCourse = courseDAO.findCourseAndReviewsByCourseId(theId);

        System.out.println("Course: " + tempCourse);
        System.out.println("Reviews: " + tempCourse.getReviews());
    }

    private void createCourseAndReviews(CourseDAO courseDAO) {

        Course tempCourse = new Course("Tech House - Beginners Guide");

        tempCourse.addReview(new Review("A great course for starters."));
        tempCourse.addReview(new Review("Highly recommended for beginners."));
        tempCourse.addReview(new Review("Good course for new learners."));

        System.out.println("Saving the course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        courseDAO.save(tempCourse);
    }

    private void deleteCourse(CourseDAO courseDAO) {

        int theId = 11;
        System.out.println("Deleting course id: " + theId);
        courseDAO.deleteCourseById(theId);
    }

    private void updateCourse(CourseDAO courseDAO) {

        int theId = 10;
        System.out.println("Finding course id: " + theId);
        Course tempCourse = courseDAO.findCourseById(theId);

        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("Progressive House - The Complete Guide");

        courseDAO.update(tempCourse);
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

        int theId = 3;
        System.out.println("Deleting student with id: " + theId);
        studentDAO.deleteStudentById(theId);
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
