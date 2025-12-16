package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Instructor;

public interface InstructorDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
