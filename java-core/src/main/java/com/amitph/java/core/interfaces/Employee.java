package com.amitph.java.core.interfaces;

public class Employee implements Comparable<Employee> {
    private Long id;
    private String name;
    private Integer age;

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.id);
    }
}
