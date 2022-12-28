package com.amitph.java.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import pl.touk.throwing.ThrowingPredicate;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StreamFilter {
    public List<Employee> filterUsingLambda(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getAge() > 50)
                .toList();
    }

    public List<Employee> filteringUsingMethodReference(List<Employee> employees) {
        return employees.stream()
                .filter(Employee::isVaccinated)
                .toList();
    }

    public List<Employee> filteringUsingMultipleConditions(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getAge() > 50 && e.isVaccinated())
                .toList();
    }

    public List<Employee> handlingExceptionsInFilterWithTryCatch(List<Employee> employees) {
        return employees.stream()
                .filter(e -> {
                    try {
                        return e.getPhoto() != null;
                    } catch (IOException ex) {
                        return false;
                    }
                })
                .toList();
    }

    public List<Employee> handlingExceptionsInFilterThrowingFunction(List<Employee> employees) {

        return employees.stream()
                .filter(ThrowingPredicate.unchecked(e -> e.getPhoto() != null))
                .toList();
    }

    public static void main(String[] a) {
        StreamFilter streamFilter = new StreamFilter();
        List<Employee> employees = List.of(
                new Employee("Janette X. Shenk", 45, true),
                new Employee("Geraldine Bean", 53, true),
                new Employee("Richard Knuckles", 55, false),
                new Employee("Lloyd Pinkerton", 52, false),
                new Employee("Louis McGriff", 42, false),
                new Employee("Amber Vang", 48, true)
        );

        System.out.println("filter() with Lambda Expressions: Employees older than 50");
        streamFilter.filterUsingLambda(employees)
                .forEach(System.out::println);

        System.out.println("filter() with Method Reference: Vaccinated Employees");
        streamFilter.filteringUsingMethodReference(employees)
                .forEach(System.out::println);

        System.out.println("filter() with Multiple Conditions: Vaccinated Employees older than 50");
        streamFilter.filteringUsingMultipleConditions(employees)
                .forEach(System.out::println);

        System.out.println("Handling Exceptions in filter(): with try/catch");
        streamFilter.handlingExceptionsInFilterWithTryCatch(employees)
                .forEach(System.out::println);

        System.out.println("Handling Exceptions in filter(): with throwing function");
        streamFilter.handlingExceptionsInFilterThrowingFunction(employees)
                .forEach(System.out::println);
    }
}

@AllArgsConstructor
@Getter
@ToString
class Employee {
    private final String name;
    private final Integer age;
    private final boolean vaccinated;

    public InputStream getPhoto() throws IOException {
        return new BufferedInputStream(new FileInputStream("/" + name + ".png"));
    }
}