package com.vimal.demo.criteriaapi.controller;

import com.vimal.demo.criteriaapi.model.Student;
import com.vimal.demo.criteriaapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }
    @GetMapping("/all")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/details/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getById(id);
    }
    @GetMapping("/get/gt/{id}")
    public List<Student> getStudentByIdGreaterThan(@PathVariable Long id){
        return studentService.getByIdGreaterThan(id);
    }
    @GetMapping("/get/or/{name}/{EnrollmentNumber}")
    public List<Student> getStudentByNameOrEnrollmentNumber(@PathVariable String name, @PathVariable String EnrollmentNumber){
        return studentService.getByNameOrEnrollmentNumber(name,EnrollmentNumber);
    }
    @GetMapping("/get/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getByName(name);
    }
    @GetMapping("/get/ne/{id}")
    public List<Student> getStudentByIdNotEqual(@PathVariable Long id){
        return studentService.getByIdNotEqual(id);
    }
    @GetMapping("/get/and/{name}/{enrollmentNumber}")
    public List<Student> getStudentStudentByNameAndEnrollmentNumber(@PathVariable String name,@PathVariable String enrollmentNumber){
        return studentService.getByNameAndEnrollmentNumber(name,enrollmentNumber);
    }
    @GetMapping("/get/not/{name}")
    public List<Student> getStudentByNameNot(@PathVariable String name){
        return studentService.getByNameNot(name);
    }
    @GetMapping("/get/lt/{id}")
    public List<Student> getStudentByIdLessThan(@PathVariable Long id){
        return studentService.getByIdLessThan(id);
    }
    @GetMapping("/get/le/{id}")
    public List<Student> getStudentByIdLessThanEqual(@PathVariable Long id){
        return studentService.getByIdLessThanEqual(id);
    }
    @GetMapping("/get/between/{id1}/{id2}")
    public List<Student> getStudentByIdBetween(@PathVariable Long id1,@PathVariable Long id2){
        return studentService.getByIdBetween(id1,id2);
    }
    @GetMapping("/get/like")
    public List<Student> getStudentByNameLike(){
        return studentService.getByNameLike();
    }
    @GetMapping("/get/lp")
    public List<Student> getStudentByNameLikePattern(){
        return studentService.getByNameLikePattern();
    }
    @GetMapping("/get/asc")
    public List<Student> getByNameAsc(){
        return studentService.getByNameAsc();
    }
    @GetMapping("/get/desc")
    public List<Student> getByNameDesc(){
        return studentService.getByNameDesc();
    }

}
