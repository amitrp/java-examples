package com.amitph.java.streams.comparator;

import com.amitph.java.streams.model.Student;

public class StudentSortUtils {

    public static int comparingFirstName(Student student1, Student student2) {
        return student1.getFirstName().compareTo(student2.getFirstName());
    }

    public static int comparingFirstAndLastName(Student student1, Student student2) {
        return (student1.getFirstName().equals(student2.getFirstName()))
                ? comparingFirstName(student1, student2)
                : student1.getLastName().compareTo(student2.getLastName());
    }
}
