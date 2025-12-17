package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Course;

public interface CourseDAO {

    Course findCourseById(int theId);

    void update(Course theCourse);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseWithReviewsByCourseId(int theId);
}
