package com.vimal.demo.criteriaapi.repository;

import com.vimal.demo.criteriaapi.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

}
