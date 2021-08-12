package com.vimal.demo.criteriaapi.service;

import com.vimal.demo.criteriaapi.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {
    public Student save(Student student);
    public Student getById(Long id);
    public List<Student> getAllStudents();
    public List<Student> getByIdGreaterThan(Long id);
    public List<Student> getByNameOrEnrollmentNumber(String name,String EnrollmentNumber);
    public List<Student> getByName(String name);
    public List<Student> getByIdNotEqual(Long id);
    public List<Student> getByNameAndEnrollmentNumber(String name, String EnrollmentNumber);
    public List<Student> getByNameNot(String name);
    public List<Student> getByIdLessThan(Long id);
    public List<Student> getByIdLessThanEqual(Long id);
    public List<Student> getByIdBetween(Long id1, Long id2);
    public List<Student> getByNameLike();
    public List<Student> getByNameLikePattern();
    public List<Student> getByNameAsc();
    public List<Student> getByNameDesc();
}
