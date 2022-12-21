package com.amitph.java.collections.map.sort;

import com.amitph.java.collections.map.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortMap {
    private Map<Long, Product> map;

    void initialize() {
        Product product1 = new Product(2L, "Television");
        Product product2 = new Product(4L, "Grinder");
        Product product3 = new Product(3L, "Headphone");
        Product product4 = new Product(5L, "Monitor");

        map = new HashMap<>();
        map.put(product1.getId(), product1);
        map.put(product2.getId(), product2);
        map.put(product3.getId(), product3);
        map.put(product4.getId(), product4);
    }

    private void usingTreeMap() {
        System.out.println("Using TreeMap: Constructor...");

        Map<Long, Product> treeMap = new TreeMap<>(map);
        treeMap.entrySet().forEach(System.out::println);

        System.out.println("Using TreeMap: putAll...");

        treeMap = new TreeMap<>();
        treeMap.putAll(map);
        treeMap.entrySet().forEach(System.out::println);
    }

    private void usingJavaStreams() {
        System.out.println("Using JavaStreams: sort by key...");

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("Using JavaStreams: sort by value...");

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

    private void usingTreeSet() {
        System.out.println("Using TreeSet: sort by key...");

        Set<Long> keys = new TreeSet<>(map.keySet());
        System.out.println(keys);

        System.out.println("Using TreeSet: sort by value...");

        Set<Product> values = new TreeSet<>(map.values());
        values.forEach(System.out::println);
    }

    private void usingArrayList() {
        System.out.println("Using ArrayList: sort by key...");

        List<Long> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        System.out.println(keys);

        System.out.println("Using ArrayList: sort by value...");

        List<Product> products = new ArrayList<>(map.values());
        Collections.sort(products);
        products.forEach(System.out::println);
    }

    public static void main(String[] a) {
        SortMap sortMap = new SortMap();
        sortMap.initialize();

        sortMap.usingTreeMap();
        sortMap.usingJavaStreams();
        sortMap.usingTreeSet();
        sortMap.usingArrayList();
    }
}