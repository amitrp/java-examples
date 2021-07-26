package com.amitph.java.streams;

import com.amitph.java.streams.model.Student;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCollections {
    Collection<Student> students;
    Map<Long, Student> studentMap;

    public static void main(String[] a) {
        SortCollections sortCollections = new SortCollections();

        sortCollections.initializeCollection();
        sortCollections.streamOfElements();
        sortCollections.streamOfCustomObjects();
        sortCollections.streamOfElements_Reversed();
        sortCollections.streamOfCustomObjects_Reversed();

        sortCollections.initializeMap();
        sortCollections.streamOfMapKeys();
        sortCollections.streamOfMapValues();
    }

    private void streamOfElements() {
        System.out.println("Sorting -> steamOfElements");

        List<String> firstNames = students.stream()
                .map(Student::getFirstName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(firstNames);
    }

    private void streamOfCustomObjects() {
        System.out.println("Sorting -> steamOfCustomObjects");

        List<Student> firstNames = students.stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());

        firstNames.forEach(System.out::println);
    }

    private void streamOfCustomObjects_Reversed() {
        System.out.println("Sorting -> steamOfCustomObjects_Reversed");

        List<Student> firstNames = students.stream()
                .sorted(Comparator.comparing(Student::getFirstName).reversed())
                .collect(Collectors.toList());

        firstNames.forEach(System.out::println);
    }

    private void streamOfElements_Reversed() {
        System.out.println("Sorting -> steamOfElements_Reversed");

        List<String> firstNames = students.stream()
                .map(Student::getFirstName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(firstNames);
    }

    private void streamOfMapKeys() {
        System.out.println("Sorting -> steamOfMapKeys");

        List<Long> studentIds = studentMap.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(studentIds);
    }

    private void streamOfMapValues() {
        System.out.println("Sorting -> streamOfMapValues");

        List<Student> students = studentMap.values().stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());

        students.forEach(System.out::println);
    }

    private void initializeCollection() {
        Student student1 = new Student(2L, "Karl", "A", 18);
        Student student2 = new Student(3L, "Jack", "P", 20);
        Student student3 = new Student(5L, "Nick", "G", 17);
        Student student4 = new Student(1L, "Tom", "A", 22);
        Student student5 = new Student(4L, "Jon", "E", 22);

        students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

    private void initializeMap() {
        Student student1 = new Student(6L, "Karl", "A", 18);
        Student student2 = new Student(3L, "Jack", "P", 20);
        Student student3 = new Student(5L, "Nick", "G", 17);
        Student student4 = new Student(1L, "Tom", "A", 22);
        Student student5 = new Student(4L, "Jon", "E", 22);

        studentMap = new HashMap<>();
        studentMap.put(student1.getStudentId(), student1);
        studentMap.put(student2.getStudentId(), student2);
        studentMap.put(student3.getStudentId(), student3);
        studentMap.put(student4.getStudentId(), student4);
        studentMap.put(student5.getStudentId(), student5);
    }
}