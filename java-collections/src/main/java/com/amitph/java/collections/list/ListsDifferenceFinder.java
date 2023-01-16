package com.amitph.java.collections.list;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListsDifferenceFinder {

    private final List<String> one = List.of("Ray", "Tim", "Leo", "Bee", "Tim");
    private final List<String> two = List.of("Ray", "Mia", "Lyn", "Bee", "Zoe", "Mia");

    public void usingPlainJava() {
        System.out.println("The first List minus the second List");
        List<String> difference = new ArrayList<>(one);
        difference.removeAll(two);

        System.out.println(difference);

        System.out.println("The second List minus the first List");
        difference = new ArrayList<>(two);
        difference.removeAll(one);

        System.out.println(difference);
    }

    public void usingStreams() {
        System.out.println("The first List minus the second List");
        List<String> difference = one.stream()
                .filter(e -> !two.contains(e))
                .toList();
        System.out.println(difference);

        System.out.println("The second List minus the first List");
        difference = two.stream()
                .filter(e -> !one.contains(e))
                .toList();
        System.out.println(difference);
    }

    public void usingApacheCommons() {
        System.out.println("The first List minus the second List");
        List<String> differences = new ArrayList<>(CollectionUtils.removeAll(one, two));
        System.out.println(differences);

        System.out.println("The second List minus the first List");
        differences = new ArrayList<>((CollectionUtils.removeAll(two, one)));
        System.out.println(differences);
    }

    public void usingGuava() {
        Set<String> differences = Sets.difference(new HashSet<>(two), new HashSet<>(one));
        System.out.println(differences);
    }


    public static void main(String[] a) {
        ListsDifferenceFinder differenceFinder = new ListsDifferenceFinder();

        System.out.println("Using Plain Java:");
        differenceFinder.usingPlainJava();

        System.out.println();
        System.out.println("Using Java Streams:");
        differenceFinder.usingStreams();

        System.out.println();
        System.out.println("Using Apache Commons Collection:");
        differenceFinder.usingApacheCommons();

        System.out.println();
        System.out.println("Using Guava:");
        differenceFinder.usingGuava();
    }
}