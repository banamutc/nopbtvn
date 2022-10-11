package com.athena.hellospring.model.request;

import java.time.LocalDate;

public class CreateStudentRequest {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String className;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public CreateStudentRequest setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public CreateStudentRequest setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public CreateStudentRequest setClassName(String className) {
        this.className = className;
        return this;
    }
}
