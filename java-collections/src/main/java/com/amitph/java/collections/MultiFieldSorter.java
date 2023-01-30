package com.amitph.java.collections;

import com.google.common.collect.ComparisonChain;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class MultiFieldSorter {
    private final List<Student> collection = new ArrayList<>(List.of(
            new Student(1L, "Ray", 18),
            new Student(2L, "Bee", 18),
            new Student(3L, "Ray", 17),
            new Student(4L, "Bia", 15),
            new Student(5L, "Ria", 15)
    ));

    public void sortUsingComparator_Field_by_Field() {
        collection.sort(new SimpleComparator());
        collection.forEach(System.out::println);
    }

    public void sortUsingComparator_Guava_ComparisonChain() {
        collection.sort(new GuavaBasedComparator());
        collection.forEach(System.out::println);
    }

    public void sortUsingComparator_Commons_CompareToBuilder() {
        collection.sort(new ApacheCommonsBasedComparator());
        collection.forEach(System.out::println);
    }

    public void sortUsingComparator_Comparing() {
        collection.sort(Comparator
                .comparing(Student::getName)
                .thenComparing(Student::getAge));
        collection.forEach(System.out::println);
    }

    public static void main(String[] a) {
        MultiFieldSorter sorter = new MultiFieldSorter();

        System.out.println("Custom Comparator - Simple");
        sorter.sortUsingComparator_Field_by_Field();

        System.out.println();
        System.out.println("Custom Comparator - Guava ComparisonChain");
        sorter.sortUsingComparator_Guava_ComparisonChain();

        System.out.println();
        System.out.println("Custom Comparator - Commons CompareToBuilder");
        sorter.sortUsingComparator_Commons_CompareToBuilder();

        System.out.println();
        System.out.println("Comparator Factory - Comparator.comparing()");
        sorter.sortUsingComparator_Comparing();
    }
}

@ToString
@Getter
@RequiredArgsConstructor
class Student {
    private final long id;
    private final String name;
    private final int age;
}

class SimpleComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int difference = o1.getName().compareTo(o2.getName());

        return (difference != 0) ? difference
                : Integer.compare(o1.getAge(), o2.getAge());
    }
}

class GuavaBasedComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return ComparisonChain.start()
                .compare(o1.getName(), o2.getName())
                .compare(o1.getAge(), o2.getAge())
                .result();
    }
}

class ApacheCommonsBasedComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return new CompareToBuilder()
                .append(o1.getName(), o2.getName())
                .append(o1.getAge(), o2.getAge())
                .build();
    }
}