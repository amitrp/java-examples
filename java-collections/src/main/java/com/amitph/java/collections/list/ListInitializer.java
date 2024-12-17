package com.amitph.java.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListInitializer {
    public void initializeJavaArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(System.out::println);
    }

    public void initializeJavaArrayListFromCollection() {
        Collection<Integer> hashSet = Set.of(1, 2, 3);
        List<Integer> list = new ArrayList<>(hashSet);

        list.forEach(System.out::println);
    }

    public void initializeJavaArrayListFromCollectorsToList() {
        List<Integer> list = Stream.of(1, 2, 3).toList();

        list.forEach(System.out::println);
    }

    public void initializeJavaArrayListFromCollectorsToCollection() {
        List<Integer> list = Stream.of(1, 2, 3).collect(Collectors.toCollection(ArrayList::new));

        list.forEach(System.out::println);
    }

    public void initializeJavaArrayListUsingAnonymousSubClass() {
        List<Integer> list =
                new ArrayList<>() {
                    {
                        add(1);
                        add(2);
                        add(3);
                    }
                };

        list.forEach(System.out::println);
    }

    public void initializeImmutableJavaArrayList() {
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Bread");
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Cheese");
        shoppingList.add("Butter");

        List<String> list = Collections.unmodifiableList(shoppingList);

        list.forEach(System.out::println);
    }

    public void initializeSingletonArrayList() {
        List<Integer> list = Collections.singletonList(1);
        list.forEach(System.out::println);
    }

    public void initializeImmutableArrayListUsingAnotherArray() {
        Integer[] array = new Integer[] {1, 2, 3};
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);

        // modify the array
        array[0] = 100;
        System.out.println(Arrays.toString(array));
        System.out.println(list);
    }

    public void initializeImmutableArrayListWithPlainJava() {
        List<Integer> list = List.of(1, 2, 3);
        list.forEach(System.out::println);
    }

    public static void main(String[] a) {
        ListInitializer initializer = new ListInitializer();

        System.out.println("Initialize ArrayList manually");
        initializer.initializeJavaArrayList();

        System.out.println("Initialize ArrayList using Collection");
        initializer.initializeJavaArrayListFromCollection();

        System.out.println("Initialize ArrayList using Stream.toList()");
        initializer.initializeJavaArrayListFromCollectorsToList();

        System.out.println("Initialize ArrayList using Collectors.toCollection()");
        initializer.initializeJavaArrayListFromCollectorsToCollection();

        System.out.println("Initialize ArrayList using Anonymous Subclass");
        initializer.initializeJavaArrayListUsingAnonymousSubClass();

        System.out.println("Initialize Immutable ArrayList using Collections.unmodifiableList()");
        initializer.initializeImmutableJavaArrayList();

        System.out.println("Initialize singleton ArrayList");
        initializer.initializeSingletonArrayList();

        System.out.println("Initialize immutable ArrayList using another Array");
        initializer.initializeImmutableArrayListUsingAnotherArray();

        System.out.println("Initialize immutable ArrayList using Plain Java");
        initializer.initializeImmutableArrayListWithPlainJava();
    }
}
