package com.amitph.java.streams;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PrediateNegater {
    public void negatePredicateWithNegate() {
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(evenNumber.negate())
                .forEach(System.out::println);
    }

    public void negatePredicateWithNot() {
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(Predicate.not(evenNumber))
                .forEach(System.out::println);
    }

    public void negateMethodReferenceWithNot() {
        Stream<Person> stream = Stream.of(
                new Person("Bob", true),
                new Person("Tom", false),
                new Person("Cob", false),
                new Person("Rick", true)
        );

        stream.filter(Predicate.not(Person::getAdult))
                .forEach(System.out::println);
    }

    public static void main(String[] a) {
        PrediateNegater prediateNegater = new PrediateNegater();

        System.out.println("Negate a Predicate using negate()");
        prediateNegater.negatePredicateWithNegate();

        System.out.println("Negate a Predicate using not()");
        prediateNegater.negatePredicateWithNot();

        System.out.println("Negate a Method Reference using not()");
        prediateNegater.negateMethodReferenceWithNot();
    }
}

@RequiredArgsConstructor
@ToString
class Person {
    private final String name;
    private final Boolean adult;

    public String getName() {
        return name;
    }

    public Boolean getAdult() {
        return adult;
    }
}