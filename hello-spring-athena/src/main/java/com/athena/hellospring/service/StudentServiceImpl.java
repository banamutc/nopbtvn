package com.athena.hellospring.service;

import com.athena.hellospring.model.entity.Student;
import com.athena.hellospring.model.request.CreateStudentRequest;
import com.athena.hellospring.model.request.UpdatedStudentRequest;
import com.athena.hellospring.model.response.StudentResponse;
import com.athena.hellospring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentResponse create(CreateStudentRequest request) {
        Student student = new Student();
        student.setId(request.getId());
        student.setName(request.getName());
        student.setClassName(request.getClassName());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        // fake repository local memory instead of mysql db
        StudentRepository.students.add(student);

        return new StudentResponse(student);
    }

    @Override
    public StudentResponse update(int id, UpdatedStudentRequest request) {

        List<Student> students = StudentRepository.students;
        Student student = students.stream().filter(studentFilter -> studentFilter.getId() == id).findAny().get();
        student.setName(request.getName());
        student.setClassName(request.getClassName());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return new StudentResponse(student);
    }

    @Override
    public List<Student> delete(int id) {
        List<Student> students = StudentRepository.students;
        students.removeIf(student -> student.getId() == id);
        return students;
    }

    @Override
    public StudentResponse read(int id) {
        List<Student> students = StudentRepository.students;
        return new StudentResponse(students.stream().filter(student -> student.getId() == id).findAny().get());
    }


}
