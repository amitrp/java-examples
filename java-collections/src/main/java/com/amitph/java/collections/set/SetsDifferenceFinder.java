package com.amitph.java.collections.set;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SetsDifferenceFinder {
    private final Set<String> one = Set.of("Ray", "Tim", "Leo", "Bee");
    private final Set<String> two = Set.of("Ray", "Mia", "Lyn", "Bee", "Zoe");

    public void usingPlainJava() {
        Set<String> difference = new HashSet<>(one);
        difference.removeAll(two);

        System.out.println(difference);
    }

    public void usingStreams() {
        Set<String> difference = one.stream()
                .filter(e -> !two.contains(e))
                .collect(Collectors.toSet());
        System.out.println(difference);
    }

    public void usingApacheCommons() {
        Set<String> differences = new HashSet<>(CollectionUtils.removeAll(one, two));
        System.out.println(differences);
    }

    public void usingGuava() {
        Set<String> differences = Sets.difference(one, two);
        System.out.println(differences);
    }

    public void symmetricDifferenceUsingApacheCommons(){
        Set<String> differences = new HashSet<>(CollectionUtils.disjunction(one, two));
        System.out.println(differences);
    }

    public static void main(String[] a) {
        SetsDifferenceFinder differenceFinder = new SetsDifferenceFinder();

        System.out.println("Plain Java:");
        differenceFinder.usingPlainJava();

        System.out.println();
        System.out.println("Java Streams:");
        differenceFinder.usingStreams();

        System.out.println();
        System.out.println("Apache Commons Collection:");
        differenceFinder.usingApacheCommons();

        System.out.println();
        System.out.println("Guava:");
        differenceFinder.usingGuava();

        System.out.println();
        System.out.println("Symmetric Difference with Apache Commons Collection:");
        differenceFinder.symmetricDifferenceUsingApacheCommons();
    }
}