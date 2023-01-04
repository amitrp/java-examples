package com.amitph.java.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListSetConverter {

    public void setToListWithJava_mutableList() {
        Set<String> set = Set.of("a", "b", "c");
        List<String> list = new ArrayList<>(set);

        System.out.println(list);
    }

    public void listToSetWithJava_mutableSet() {
        List<String> list = List.of("a", "b", "c", "a");
        Set<String> set = new HashSet<>(list);

        System.out.println(set);
    }

    public void setToListWithJava_immutableList() {
        Set<String> set = Set.of("a", "b", "c");
        List<String> list = List.copyOf(set);

        System.out.println(list);
    }

    public void listToSetWithJava_immutableSet() {
        List<String> list = List.of("a", "b", "c", "a");
        Set<String> set = Set.copyOf(list);

        System.out.println(set);
    }

    public void setToListWithGuava() {
        Set<String> set = Set.of("a", "b", "c");
        List<String> list = Lists.newArrayList(set);

        System.out.println(list);
    }

    public void listToSetWithGuava() {
        List<String> list = List.of("a", "b", "c", "a");
        Set<String> set = Sets.newHashSet(list);

        System.out.println(set);
    }

    public void setToListWithApacheCommons() {
        Set<String> set = Set.of("a", "b", "c");
        List<String> list = new ArrayList<>();
        CollectionUtils.addAll(list, set);

        System.out.println(list);
    }

    public void listToSetWithApacheCommons() {
        List<String> list = List.of("a", "b", "c", "a");
        Set<String> set = new HashSet<>();
        CollectionUtils.addAll(set, list);

        System.out.println(set);
    }


    public static void main(String[] a) {
        ListSetConverter converter = new ListSetConverter();

        System.out.println("Set to List using Java - mutable List");
        converter.setToListWithJava_mutableList();

        System.out.println("Set to List using Java - immutable List");
        converter.setToListWithJava_immutableList();

        System.out.println("Set to List using Guava");
        converter.setToListWithGuava();

        System.out.println("Set to List using Apache Commons");
        converter.setToListWithApacheCommons();

        System.out.println("List to Set using Java - mutable Set");
        converter.listToSetWithJava_mutableSet();

        System.out.println("List to Set using Java - immutable Set");
        converter.listToSetWithJava_immutableSet();

        System.out.println("List to Set using Guava");
        converter.listToSetWithGuava();

        System.out.println("List to Set using Apache Commons");
        converter.listToSetWithApacheCommons();
    }
}