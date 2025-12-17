package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Course;
import com.example.springcruddemo.entity.Instructor;
import com.example.springcruddemo.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor theInstructor);

    Course findCourseById(int theId);

    void update(Course theCourse);

    void deleteCourseById(int theId);
}
