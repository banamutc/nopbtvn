package com.athena.hellospring.controller;


import com.athena.hellospring.model.entity.Student;
import com.athena.hellospring.model.request.CreateStudentRequest;
import com.athena.hellospring.model.request.UpdatedStudentRequest;
import com.athena.hellospring.model.response.StudentResponse;
import com.athena.hellospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.athena.hellospring.repository.StudentRepository.students;

@RestController
@RequestMapping("/athena")
public class HelloAthenaController {

    @Autowired
    private StudentService service;

    @GetMapping("/jb101")
    public String willing() {
        return theEnd();
    }

    @PostMapping("/jb101")
    public String theEnd() {
        return "The End";
    }

    @PostMapping("/student")
    public ResponseEntity<StudentResponse> create(@RequestBody CreateStudentRequest request) {
        StudentResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    List<Student> getAllStudent() {
        return students;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable(name = "id") int id, @RequestBody UpdatedStudentRequest request) {
        StudentResponse response1 = service.update(id, request);
        return ResponseEntity.ok(response1);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Student>> delete(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<StudentResponse> get(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(service.read(id));
    }
}
