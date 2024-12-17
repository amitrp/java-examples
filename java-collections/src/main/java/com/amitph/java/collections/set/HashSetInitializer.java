package com.amitph.java.collections.set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashSetInitializer {
    public void initializeJavaHashSet() {
        Set<String> shoppingSet = new HashSet<>();

        shoppingSet.add("Bread");
        shoppingSet.add("Milk");
        shoppingSet.add("Eggs");
        shoppingSet.add("Cheese");
        shoppingSet.add("Butter");

        shoppingSet.forEach(System.out::println);
    }

    public void initializeJavaHashSetFromList() {
        Map<String, String> map =
                Map.of(
                        "color", "black",
                        "drink", "coffee",
                        "shape", "slim");
        Set<String> set = new HashSet<>(map.keySet());

        set.forEach(System.out::println);
    }

    public void initializeJavaHashSetFromCollection() {
        List<String> shoppingList = List.of("Bread", "Milk", "Eggs", "Cheese", "Butter");
        Set<String> shoppingSet = new HashSet<>(shoppingList);

        shoppingSet.forEach(System.out::println);
    }

    public void initializeJavaHashSetFromCollectorsToSet() {
        Set<String> shoppingSet =
                Stream.of("Bread", "Milk", "Eggs", "Cheese", "Butter").collect(Collectors.toSet());

        shoppingSet.forEach(System.out::println);
    }

    public void initializeJavaHashSetFromCollectorsToCollection() {
        Set<String> shoppingSet =
                Stream.of("Bread", "Milk", "Eggs", "Cheese", "Butter")
                        .collect(Collectors.toCollection(HashSet::new));

        shoppingSet.forEach(System.out::println);
    }

    public void initializeJavaHashSetUsingAnonymousSubClass() {
        Set<String> shoppingSet =
                new HashSet<>() {
                    {
                        add("Bread");
                        add("Milk");
                        add("Eggs");
                        add("Cheese");
                        add("Butter");
                    }
                };

        shoppingSet.forEach(System.out::println);
    }

    public void initializeImmutableJavaHashSet() {
        Set<String> shoppingSet = new HashSet<>();

        shoppingSet.add("Bread");
        shoppingSet.add("Milk");
        shoppingSet.add("Eggs");
        shoppingSet.add("Cheese");
        shoppingSet.add("Butter");

        Set<String> immutableSet = Collections.unmodifiableSet(shoppingSet);

        immutableSet.forEach(System.out::println);
    }

    public void initializeSingletonHashSet() {
        Set<String> singletonSet = Collections.singleton("Bread");
        singletonSet.forEach(System.out::println);
    }

    public void initializeImmutableHashSetUsingGuava() {
        Set<String> shoppingSet = ImmutableSet.of("Bread", "Milk", "Eggs", "Cheese", "Butter");
        shoppingSet.forEach(System.out::println);
    }

    public void initializeMutableHashSetUsingGuava() {
        Set<String> shoppingSet = Sets.newHashSet("Bread", "Milk", "Eggs", "Cheese", "Butter");
        shoppingSet.forEach(System.out::println);
    }

    public void initializeImmutableHashSetWithPlainJava() {
        Set<String> shoppingSet = Set.of("Bread", "Milk", "Eggs", "Cheese", "Butter");
        shoppingSet.forEach(System.out::println);
    }

    public static void main(String[] a) {
        HashSetInitializer initializer = new HashSetInitializer();

        System.out.println("Initialize HashSet manually");
        initializer.initializeJavaHashSet();

        System.out.println("Initialize HashSet using List");
        initializer.initializeJavaHashSetFromList();

        System.out.println("Initialize HashSet using Collection");
        initializer.initializeJavaHashSetFromCollection();

        System.out.println("Initialize HashSet using Collectors.toSet()");
        initializer.initializeJavaHashSetFromCollectorsToSet();

        System.out.println("Initialize HashSet using Collectors.toCollection()");
        initializer.initializeJavaHashSetFromCollectorsToCollection();

        System.out.println("Initialize HashSet using Anonymous Subclass");
        initializer.initializeJavaHashSetUsingAnonymousSubClass();

        System.out.println("Initialize Immutable HashSet using Collections.unmodifiableSet()");
        initializer.initializeImmutableJavaHashSet();

        System.out.println("Initialize singleton HashSet");
        initializer.initializeSingletonHashSet();

        System.out.println("Initialize immutable HashSet using Guava");
        initializer.initializeImmutableHashSetUsingGuava();

        System.out.println("Initialize mutable HashSet using Guava");
        initializer.initializeMutableHashSetUsingGuava();

        System.out.println("Initialize immutable HashSet using Plain Java");
        initializer.initializeImmutableHashSetWithPlainJava();
    }
}
