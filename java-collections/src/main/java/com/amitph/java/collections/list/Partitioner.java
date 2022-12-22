package com.amitph.java.collections.list;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class Partitioner {
    public <T> List<List<T>> partitionListUsingGuava(List<T> list, int size) {
        return Lists.partition(list, size);
    }

    public <T> Iterable<List<T>> partitionCollectionUsingGuava(Collection<T> list, int size) {
        return Iterables.partition(list, size);
    }

    public <T> Iterable<List<T>> paddedPartitionCollectionUsingGuava(Collection<T> list, int size) {
        return Iterables.paddedPartition(list, size);
    }

    public <T> List<List<T>> partitionListUsingApacheCommons(List<T> list, int size) {
        return ListUtils.partition(list, size);
    }

    public <T> List<List<T>> partitionListUsingPlainJava(List<T> list, int size) {

        List<List<T>> partitions = new ArrayList<>();
        if (list.size() == 0) {
            return partitions;
        }

        int length = list.size();
        int numOfPartitions = length / size + ((length % size == 0) ? 0 : 1);

        for (int i = 0; i < numOfPartitions; i++) {
            int from = i * size;
            int to = Math.min((i * size + size), length);
            partitions.add(list.subList(from, to));
        }
        return partitions;
    }

    public static void main(String[] a) {
        Partitioner partitioner = new Partitioner();

        System.out.println("Partition a Java List: Using Guava");
        List<Integer> list = IntStream.rangeClosed(1, 21).boxed().toList();
        partitioner.partitionListUsingGuava(list, 5)
                .forEach(System.out::println);


        System.out.println("Partition a Java Collection: Using Guava");
        Collection<Integer> collection = IntStream.rangeClosed(1, 21).boxed().toList();
        partitioner.partitionCollectionUsingGuava(collection, 5)
                .forEach(System.out::println);

        System.out.println("Partition a Java Collection: Using Guava");
        partitioner.paddedPartitionCollectionUsingGuava(collection, 5)
                .forEach(System.out::println);

        System.out.println("Partition a Java List: Using Apache Commons Collections");
        partitioner.partitionListUsingApacheCommons(list, 5)
                .forEach(System.out::println);

        System.out.println("Partition a Java List: Using Plain Java");
        partitioner.partitionListUsingPlainJava(list, 5)
                .forEach(System.out::println);
    }
}
