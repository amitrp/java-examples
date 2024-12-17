package com.amitph.java.streams;

import java.util.List;
import java.util.function.Predicate;

public class PredicateChain {
    public void filterWithSinglePredicate() {
        List<String> names = List.of("Maria", "Sandra", "Rachel", "Mary", "Michael");
        List<String> output = names.stream().filter(n -> n.startsWith("M")).toList();
        output.forEach(System.out::println);
    }

    public void multipleFiltersWithPredicates() {
        List<String> names = List.of("Maria", "Sandra", "Rachel", "Mary", "Michael");
        List<String> output =
                names.stream().filter(n -> n.startsWith("M")).filter(n -> n.length() > 4).toList();
        output.forEach(System.out::println);
    }

    public void filterWithTwoConditions() {
        List<String> names = List.of("Maria", "Sandra", "Rachel", "Mary", "Michael");
        List<String> output =
                names.stream().filter(n -> n.startsWith("M") && n.length() > 4).toList();
        output.forEach(System.out::println);
    }

    public void filterWithPredicateAnd() {
        Predicate<String> predicate1 = n -> n.startsWith("M");
        Predicate<String> predicate2 = n -> n.length() > 4;

        List<String> names = List.of("Maria", "Sandra", "Rachel", "Mary", "Michael");
        List<String> output = names.stream().filter(predicate1.and(predicate2)).toList();
        output.forEach(System.out::println);
    }

    public void filterWithPredicateOr() {
        Predicate<String> predicate1 = n -> n.startsWith("M");
        Predicate<String> predicate2 = n -> n.length() > 4;

        List<String> names = List.of("Maria", "Sandra", "Rachel", "Mary", "Michael");
        List<String> output = names.stream().filter(predicate1.or(predicate2)).toList();
        output.forEach(System.out::println);
    }

    public void filterWithPredicateNegate() {
        Predicate<String> predicate1 = n -> n.startsWith("M");
        Predicate<String> predicate2 = n -> n.length() > 4;

        List<String> names = List.of("Maria", "Sandra", "Rachel", "Mary", "Michael");
        List<String> output =
                names.stream().filter(predicate1.negate().or(predicate2.negate())).toList();
        output.forEach(System.out::println);
    }

    public void filterWithPredicateCollectionAnd() {
        List<Predicate<String>> predicates = List.of(n -> n.startsWith("M"), n -> n.length() > 4);

        List<String> names = List.of("Maria", "Sandra", "Rachel", "Mary", "Michael");
        List<String> output =
                names.stream()
                        .filter(predicates.stream().reduce(p -> true, Predicate::and))
                        .toList();
        output.forEach(System.out::println);
    }

    public void filterWithPredicateCollectionOr() {
        List<Predicate<String>> predicates = List.of(n -> n.startsWith("M"), n -> n.length() > 4);

        List<String> names = List.of("Maria", "Sandra", "Rachel", "Mary", "Michael");
        List<String> output =
                names.stream()
                        .filter(predicates.stream().reduce(p -> false, Predicate::or))
                        .toList();
        output.forEach(System.out::println);
    }

    public static void main(String[] a) {
        PredicateChain predicateChain = new PredicateChain();

        System.out.println("Filter with a single Predicate");
        predicateChain.filterWithSinglePredicate();

        System.out.println("Multiple filters with Predicates");
        predicateChain.multipleFiltersWithPredicates();

        System.out.println("Filter with two conditions");
        predicateChain.filterWithTwoConditions();

        System.out.println("Filter with Predicates combined with and()");
        predicateChain.filterWithPredicateAnd();

        System.out.println("Filter with Predicates combined with or()");
        predicateChain.filterWithPredicateOr();

        System.out.println("Filter with Predicates combined with negate()");
        predicateChain.filterWithPredicateNegate();

        System.out.println("Filter with Collection of Predicates combined with and()");
        predicateChain.filterWithPredicateCollectionAnd();

        System.out.println("Filter with Collection of Predicates combined with or()");
        predicateChain.filterWithPredicateCollectionOr();
    }
}
