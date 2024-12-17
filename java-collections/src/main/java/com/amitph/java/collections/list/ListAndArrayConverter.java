package com.amitph.java.collections.list;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class ListAndArrayConverter {
    public void arrayToListUsingJava_createImmutableList() {
        Integer[] array = new Integer[] {98, 99, 100};
        List<Integer> list = Arrays.asList(array);

        System.out.println(list);
    }

    public void listToArrayUsingJava() {
        List<Integer> list = List.of(50, 51, 52);
        Integer[] array = list.toArray(new Integer[0]);

        System.out.println(Arrays.toString(array));
    }

    public void arrayToListUsingJava_createMutableList() {
        Integer[] array = new Integer[] {98, 99, 100};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));

        System.out.println(list);
    }

    public void arrayToListUsingApacheCommons() {
        Integer[] array = new Integer[] {98, 99, 100};
        List<Integer> list = new ArrayList<>();
        CollectionUtils.addAll(list, array);

        System.out.println(list);
    }

    public void arrayToListUsingGuava() {
        Integer[] array = new Integer[] {98, 99, 100};
        List<Integer> list = Lists.newArrayList(array);

        System.out.println(list);
    }

    public void listToArrayUsingGuava() {
        List<Integer> list = List.of(50, 51, 52);
        int[] array = Ints.toArray(list);

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] a) {
        ListAndArrayConverter converter = new ListAndArrayConverter();

        System.out.println("Array to List using Java - immutable List");
        converter.arrayToListUsingJava_createImmutableList();

        System.out.println("Array to List using Java - mutable List");
        converter.arrayToListUsingJava_createMutableList();

        System.out.println("Array to List using Apache commons");
        converter.arrayToListUsingApacheCommons();

        System.out.println("Array to List using Guava");
        converter.arrayToListUsingGuava();

        System.out.println("List to Array using Java");
        converter.listToArrayUsingJava();

        System.out.println("List to Array using Guava");
        converter.listToArrayUsingGuava();
    }
}
