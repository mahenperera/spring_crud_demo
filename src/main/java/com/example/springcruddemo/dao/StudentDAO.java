package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void deleteStudentById(int id);

    int deleteAll();

    Student findStudentAndCoursesByStudentId(int theId);
}
