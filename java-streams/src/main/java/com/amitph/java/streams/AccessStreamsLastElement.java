package com.amitph.java.streams;

import com.google.common.collect.Streams;
import java.util.stream.Stream;

public class AccessStreamsLastElement {
    public <T> T usingReduction(Stream<T> stream) {
        return stream.reduce((t, t2) -> t2).orElse(null);
    }

    public <T> T usingGuava(Stream<T> stream) {
        return Streams.findLast(stream).orElse(null);
    }

    public <T> T usingSkip(Stream<T> stream) {
        long count = stream.count();
        return stream.skip(count).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        AccessStreamsLastElement le = new AccessStreamsLastElement();

        System.out.println("Stream's last element - using Reduction");
        System.out.println(le.usingReduction(Stream.of(1, 2, 3, 4, 5)));

        System.out.println("Stream's last element - using Guava");
        System.out.println(le.usingGuava(Stream.of(11, 32, 34, 6, 7)));

        System.out.println("Stream's last element - using Skip");
        System.out.println(le.usingGuava(Stream.of(22, 34, 14, 4, 30)));

        System.out.println("Stream's last element of infinite stream");
        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 1);
        System.out.println(le.usingGuava(infiniteStream.limit(1000)));
    }
}
