package com.amitph.java.streams.model;

import lombok.Data;

@Data
public class Student implements Comparable<Student> {
    private final Long studentId;
    private final String firstName;
    private final String lastName;
    private final Integer age;

    @Override
    public int compareTo(Student student) {
        return this.firstName.compareTo(student.firstName);
    }
}