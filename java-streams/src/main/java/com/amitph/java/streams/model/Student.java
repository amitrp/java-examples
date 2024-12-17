package com.amitph.java.streams.model;

import lombok.Data;

@Data
public class Student {
    private final Long studentId;
    private final String firstName;
    private final String lastName;
    private final Integer age;
}
