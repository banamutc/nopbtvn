package com.athena.hellospring.service;

import com.athena.hellospring.model.entity.Student;
import com.athena.hellospring.model.request.CreateStudentRequest;
import com.athena.hellospring.model.request.UpdatedStudentRequest;
import com.athena.hellospring.model.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse create(CreateStudentRequest request);

    StudentResponse update(int id, UpdatedStudentRequest request);

    List<Student> delete(int id);

    StudentResponse read(int id);
}
