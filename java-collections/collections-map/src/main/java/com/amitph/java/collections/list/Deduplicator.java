package com.amitph.java.collections.list;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Deduplicator {
    public <T> List<T> usingStreamDistinct(List<T> list) {
        return list.stream()
                .distinct()
                .toList();
    }

    public <T> List<T> usingJavaSet(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] ar) {
        Deduplicator deduplicator = new Deduplicator();

        System.out.println("Remove duplicates from list: using Streams distinct()");
        deduplicator.usingStreamDistinct(List.of(1, 2, 4, 2, 1, 4, 2, 5, 6, 4))
                .forEach(System.out::print);

        System.out.println();
        System.out.println("Remove duplicates from list: using Java Set");
        deduplicator.usingJavaSet(List.of(1, 2, 4, 2, 1, 4, 2, 5, 6, 4))
                .forEach(System.out::print);
    }
}