package com.amitph.java.collections.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HashSetSorter {
    public void usingCollectionsSort() {
        Set<Integer> set = Set.of(3, 2, 5, 4, 1, 6, 8, 7);

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);
    }

    public void usingTreeSet() {
        Set<Integer> hashSet = Set.of(3, 2, 5, 4, 1, 6, 8, 7);
        Set<Integer> treeSet = new TreeSet<>(hashSet);

        System.out.println(treeSet);
    }

    public void usingStreamSorted() {
        Set<Integer> hashSet = Set.of(3, 2, 5, 4, 1, 6, 8, 7);
        Set<Integer> linkedHashSet =
                hashSet.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(linkedHashSet);
    }

    public static void main(String[] a) {
        HashSetSorter setSorter = new HashSetSorter();

        System.out.println("Using Collections.sort()");
        setSorter.usingCollectionsSort();

        System.out.println("Using TreeSet");
        setSorter.usingTreeSet();

        System.out.println("Using Stream.sorted()");
        setSorter.usingStreamSorted();
    }
}
