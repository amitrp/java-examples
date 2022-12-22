package com.amitph.java.streams;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Deduplicator {
    public static void main(String[] ar) {
        Deduplicator deduplicator = new Deduplicator();

        System.out.println("Remove duplicate elements of a Stream - using distinct()");
        deduplicator
                .deduplicateUsingDistinct(Stream.of("a", "b", "c", "b", "d", "a", "d"))
                .forEach(System.out::println);


        System.out.println();
        System.out.println("Remove duplicate elements of a Stream - using Set");
        deduplicator
                .deduplicateUsingSet(Stream.of("a", "b", "c", "b", "d", "a", "d"))
                .forEach(System.out::println);


        System.out.println();
        System.out.println("Remove duplicate elements of a Stream of custom objects");
        deduplicator
                .deduplicateUsingDistinct(getStudentStream())
                .forEach(System.out::println);


        System.out.println();
        System.out.println("Remove duplicate elements of a Stream of custom objects by specific fields");
        Stream<StudentWrapper> wrapperStream = getStudentStream().map(StudentWrapper::new);

        deduplicator
                .deduplicateUsingDistinct(wrapperStream)
                .map(StudentWrapper::getStudent)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Counting the duplicates in a Stream");
        deduplicator.groupByCount(Stream.of(22, 31, 22, 34, 25, 31, 34))
                .entrySet()
                .forEach(System.out::println);
    }

    public <T> Stream<T> deduplicateUsingDistinct(Stream<T> stream) {
        return stream.distinct();
    }

    public <T> Stream<T> deduplicateUsingSet(Stream<T> stream) {
        return stream
                .collect(Collectors.toSet())
                .stream();
    }

    public <T> Map<T, Long> groupByCount(Stream<T> stream) {
        return stream
                .collect(toMap(Function.identity(), x -> 1L, Long::sum));
    }

    private static Stream<Student> getStudentStream() {
        return Stream.of(
                new Student(1L, "Bob", "Jack", 12),
                new Student(2L, "Nick", "Stephen", 14),
                new Student(3L, "Bob", "Holden", 14),
                new Student(2L, "Nick", "Stephen", 14)
        );
    }
}

@Data
class Student {
    private final Long studentId;
    private final String firstName;
    private final String lastName;
    private final Integer age;

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Student student2)) {
            return false;
        }
        return student2.studentId.equals(this.studentId);
    }

    @Override
    public int hashCode() {
        return studentId.hashCode();
    }
}

@Getter
@RequiredArgsConstructor
class StudentWrapper {
    private final Student student;

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof StudentWrapper wrapper2)) {
            return false;
        }
        return wrapper2.student.getFirstName()
                .equals(this.student.getFirstName());
    }

    @Override
    public int hashCode() {
        return student.getFirstName().hashCode();
    }
}