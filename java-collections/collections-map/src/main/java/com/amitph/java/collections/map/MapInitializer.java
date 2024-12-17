package com.amitph.java.collections.map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapInitializer {

    public void initializeJavaHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("color", "black");
        map.put("drink", "coffee");
        map.put("shape", "slim");

        System.out.println(map);
    }

    public void initializeJavaHashMapUsingAnonymousSubClass() {
        Map<String, String> map =
                new HashMap<>() {
                    {
                        put("color", "black");
                        put("drink", "coffee");
                        put("shape", "slim");
                    }
                };

        System.out.println(map);
    }

    public void initializeImmutableJavaHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("color", "black");
        map.put("drink", "coffee");
        map.put("shape", "slim");

        Map<String, String> immutableMap = Collections.unmodifiableMap(map);

        System.out.println(immutableMap);
    }

    public void initializeSingletonJavaHashMap() {
        Map<String, String> map = Collections.singletonMap("color", "black");
        System.out.println(map);
    }

    public void initializeEmptyJavaHashMap() {
        Map<String, String> map = Collections.emptyMap();
        System.out.println(map);
    }

    public void initializeImmutableJavaHashMapUsingGuava() {
        Map<String, String> immutableMap =
                ImmutableMap.of("color", "pink", "drink", "coffee", "shape", "slim");

        System.out.println(immutableMap);
    }

    public void initializeMutableJavaHashMapUsingGuava() {
        Map<String, String> immutableMap =
                ImmutableMap.of("color", "pink", "drink", "coffee", "shape", "slim");

        Map<String, String> mutableMap = Maps.newHashMap(immutableMap);
        System.out.println(mutableMap);
    }

    public void initializeJavaHashMapUsingCollectorsToMap() {
        Set<String> set = Set.of("Pink", "Red", "Black");
        Map<String, String> map =
                set.stream().collect(Collectors.toMap(String::toUpperCase, String::toLowerCase));

        System.out.println(map);
    }

    public void initializeJavaHashMapUsingMapOf() {
        Map<String, String> immutableMap = Map.of("color", "black", "drink", "coffee");

        System.out.println(immutableMap);
    }

    public void initializeJavaHashMapUsingMapOfEntries() {
        Map<String, String> immutableMap =
                Map.ofEntries(Map.entry("color", "pink"), Map.entry("drink", "coffee"));

        System.out.println(immutableMap);
    }

    public static void main(String[] a) {
        MapInitializer initializer = new MapInitializer();

        System.out.println("Initialize HashMap manually");
        initializer.initializeJavaHashMap();

        System.out.println("Initialize HashMap using anonymous subclass");
        initializer.initializeJavaHashMapUsingAnonymousSubClass();

        System.out.println("Initialize immutable HashMap");
        initializer.initializeImmutableJavaHashMap();

        System.out.println("Initialize singleton HashMap");
        initializer.initializeSingletonJavaHashMap();

        System.out.println("Initialize empty HashMap");
        initializer.initializeEmptyJavaHashMap();

        System.out.println("Initialize immutable HashMap using Guava");
        initializer.initializeImmutableJavaHashMapUsingGuava();

        System.out.println("Initialize mutable HashMap using Guava");
        initializer.initializeMutableJavaHashMapUsingGuava();

        System.out.println("Initialize HashMap using Collectors toMap()");
        initializer.initializeJavaHashMapUsingCollectorsToMap();

        System.out.println("Initialize HashMap using factory method of()");
        initializer.initializeJavaHashMapUsingMapOf();

        System.out.println("Initialize HashMap using factory method ofEntries()");
        initializer.initializeJavaHashMapUsingMapOfEntries();
    }
}
