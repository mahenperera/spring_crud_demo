package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Course;
import com.example.springcruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    // Inject Entity Manager using Constructor Injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    // No need to add @Transactional since this is a read only query
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        // Student and lastName in the query are JPA Entity and Field names not database table or column names
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        theQuery.setParameter("theData", theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {

        Student tempStudent = entityManager.find(Student.class, id);

        if (tempStudent != null) {

            List<Course> courses = tempStudent.getCourses();

            for (Course tempCourse : courses) {
                tempCourse.getStudents().remove(tempStudent);
            }

            entityManager.remove(tempStudent);
        }
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s "
                                                                + "JOIN FETCH s.courses "
                                                                + "WHERE s.id = :data", Student.class);

        query.setParameter("data", theId);

        Student student = query.getSingleResult();

        return student;
    }
}
