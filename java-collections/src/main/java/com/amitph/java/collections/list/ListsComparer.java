package com.amitph.java.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;

public class ListsComparer {
    public void checkEquality() {
        List<Integer> one = List.of(1, 2, 4, 6, 8);
        List<Integer> two = List.of(1, 2, 4, 6, 8);
        List<Integer> three = List.of(1, 2, 4, 6, 8, 4);

        System.out.println(one.equals(two));
        System.out.println(one.equals(three));
    }

    public void findCommonElements() {
        List<Integer> one = List.of(1, 2, 4, 6, 8);
        List<Integer> two = List.of(3, 4, 5, 6, 7);

        // Plain Java
        List<Integer> commons = new ArrayList<>(one);
        commons.retainAll(two);
        System.out.println(commons);

        // Java Streams
        commons = one.stream().filter(two::contains).toList();
        System.out.println(commons);

        // Apache Commons Collections
        commons = new ArrayList<>(CollectionUtils.intersection(one, two));
        System.out.println(commons);
    }

    public void findDifferentElements() {
        List<Integer> one = List.of(1, 2, 4, 6, 8);
        List<Integer> two = List.of(3, 4, 5, 6, 7);

        // Plain Java
        List<Integer> difference = new ArrayList<>(one);
        difference.removeAll(two);
        System.out.println(difference);

        // Java Streams
        difference = one.stream().filter(Predicate.not(two::contains)).toList();
        System.out.println(difference);

        // Apache Commons Collections
        difference = new ArrayList<>(CollectionUtils.removeAll(one, two));
        System.out.println(difference);
    }

    public static void main(String[] a) {
        ListsComparer comparer = new ListsComparer();
        comparer.checkEquality();
        comparer.findCommonElements();
        comparer.findDifferentElements();
    }
}
