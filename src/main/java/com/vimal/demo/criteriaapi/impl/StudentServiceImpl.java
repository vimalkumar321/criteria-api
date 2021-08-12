package com.vimal.demo.criteriaapi.impl;

import com.vimal.demo.criteriaapi.model.Student;
import com.vimal.demo.criteriaapi.repository.StudentRepository;
import com.vimal.demo.criteriaapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Student save(Student student){
        entityManager.persist(student);
        return student;
    }

    @Transactional
    public Student getById(Long id){
        //return entityManager.find(Student.class, id);
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        criteriaQuery.where(criteriaBuilder.equal(studentRoot.get("id"), id ));
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList.get(0);
    }

    @Transactional
    public List<Student> getAllStudents(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    @Transactional
    public List<Student> getByName(String name) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.equal(studentRoot.get("name"), name);
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    @Transactional
    public List<Student> getByIdNotEqual(Long id) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.notEqual(studentRoot.get("id"), id);
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    @Transactional
    public List<Student> getByNameOrEnrollmentNumber(String name, String enrollmentNumber) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicateName = criteriaBuilder.equal(studentRoot.get("name"), name);
        Predicate predicateEnrollmentNumber = criteriaBuilder.equal(studentRoot.get("enrollmentNumber"), enrollmentNumber);
        Predicate nameOrEnrollmentNumberPredicate = criteriaBuilder.or(predicateName, predicateEnrollmentNumber);
        criteriaQuery.where(nameOrEnrollmentNumberPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }

    @Transactional
    public List<Student> getByNameAndEnrollmentNumber(String name, String rollNumber) {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicateName = criteriaBuilder.equal(studentRoot.get("name"), name);
        Predicate predicateRollNumber = criteriaBuilder.equal(studentRoot.get("enrollmentNumber"), rollNumber);
        Predicate nameOrRollNumberPredicate = criteriaBuilder.and(predicateName, predicateRollNumber);
        criteriaQuery.where(nameOrRollNumberPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }

    @Transactional
    public List<Student> getByNameNot(String name) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicateName = criteriaBuilder.equal(studentRoot.get("name"), name);
        Predicate lastPredicate = criteriaBuilder.not(predicateName);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    @Transactional
    public List<Student> getByIdGreaterThan(Long id) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate lastPredicate = criteriaBuilder.gt(studentRoot.get("id").as(Long.class), id);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    @Transactional
    public List<Student> getByIdLessThan(Long id) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate lastPredicate = criteriaBuilder.lt(studentRoot.get("id").as(Long.class), id);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    @Transactional
    public List<Student> getByIdLessThanEqual(Long id) {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.le(studentRoot.get("id"), id);
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }

    @Transactional
    public List<Student> getByIdBetween(Long id1, Long id2) {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate lastPredicate = criteriaBuilder.between(studentRoot.get("id").as(Long.class),id1,id2);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    @Transactional
    public List<Student> getByNameLike() {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.like(studentRoot.get("name"), "r");
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }

    @Transactional
    public List<Student> getByNameLikePattern() {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.like(studentRoot.get("name"), "%r%");
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }

    @Transactional
    public List<Student> getByNameAsc() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        criteriaQuery.orderBy(criteriaBuilder.asc(studentRoot.get("name")));
        List<Student> students = entityManager.createQuery(criteriaQuery).getResultList();
        return students;
    }

    @Transactional
    public List<Student> getByNameDesc() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.orderBy(criteriaBuilder.desc(studentRoot.get("name")));
        List<Student> students = entityManager.createQuery(criteriaQuery).getResultList();
        return students;
    }

}
