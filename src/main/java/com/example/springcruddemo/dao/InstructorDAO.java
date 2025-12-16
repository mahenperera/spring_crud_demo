package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Instructor;
import com.example.springcruddemo.entity.InstructorDetail;

public interface InstructorDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
