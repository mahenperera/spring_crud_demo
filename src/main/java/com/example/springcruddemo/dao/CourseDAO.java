package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Course;

public interface CourseDAO {

    Course findCourseById(int theId);

    void update(Course theCourse);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);
}
