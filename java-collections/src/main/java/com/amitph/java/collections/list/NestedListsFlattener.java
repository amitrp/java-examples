package com.amitph.java.collections.list;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.assertj.core.util.Lists;

public class NestedListsFlattener {
    private final List<List<Integer>> list =
            List.of(List.of(1, 4, 3), List.of(12, 17, 14), List.of(31, 39, 32));

    public void usingForEach() {
        List<Integer> output = new ArrayList<>();
        list.forEach(output::addAll);

        System.out.println(output);
    }

    public void usingFlatMap() {
        List<Integer> output = list.stream().flatMap(Collection::stream).toList();

        System.out.println(output);
    }

    public void usingGuava() {
        List<Integer> output = Lists.newArrayList(Iterables.concat(list));
        System.out.println(output);
    }

    public static void main(String[] a) {
        NestedListsFlattener flattener = new NestedListsFlattener();

        System.out.println("Using forEach()");
        flattener.usingForEach();

        System.out.println("Using flatMap()");
        flattener.usingFlatMap();

        System.out.println("Using Guava");
        flattener.usingGuava();
    }
}
