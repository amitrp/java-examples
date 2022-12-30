package com.amitph.java.streams;

import one.util.streamex.StreamEx;
import org.jooq.lambda.Seq;

import java.util.stream.Stream;

public class MergeStreams {
    public void mergeTwoStreamsWithJavaConcat() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(7, 8, 9);

        Stream<Integer> merged = Stream.concat(stream1, stream2);

        merged.forEach(System.out::println);
    }

    public void mergeMultipleStreamsWithJavaConcat() {
        Stream<Integer> stream1 = Stream.of(1, 2);
        Stream<Integer> stream2 = Stream.of(3, 4);
        Stream<Integer> stream3 = Stream.of(5, 6);
        Stream<Integer> stream4 = Stream.of(7, 8);

        Stream<Integer> merged = Stream.concat(stream1, Stream.concat(stream2,
                Stream.concat(stream3, stream4)));

        merged.forEach(System.out::println);
    }

    public void mergeMultipleStreamsWithJavaFlatMap() {
        Stream<Integer> stream1 = Stream.of(1, 2);
        Stream<Integer> stream2 = Stream.of(3, 4);
        Stream<Integer> stream3 = Stream.of(5, 6);
        Stream<Integer> stream4 = Stream.of(7, 8);

        Stream<Integer> merged =
                Stream.of(stream1, stream2, stream3, stream4)
                        .flatMap(x -> x);

        merged.forEach(System.out::println);
    }

    public void mergeMultipleStreamsWithStreamExAppend() {
        Stream<Integer> stream1 = Stream.of(1, 2);
        Stream<Integer> stream2 = Stream.of(4, 5);
        Stream<Integer> stream3 = Stream.of(7, 8);

        Stream<Integer> merged = StreamEx.of(stream1)
                .append(stream2)
                .append(stream3);

        merged.forEach(System.out::println);
    }

    public void mergeMultipleStreamsWithStreamExAppendPrepend() {
        Stream<Integer> stream1 = Stream.of(4);
        Stream<Integer> stream2 = Stream.of(1, 2);
        Stream<Integer> stream3 = Stream.of(6, 7);

        Stream<Integer> merged = StreamEx.of(stream1)
                .append(stream3)
                .prepend(stream2);

        merged.forEach(System.out::println);
    }

    public void mergeMultipleStreamsWithJoolAppend() {
        Stream<Integer> stream1 = Stream.of(1, 2);
        Stream<Integer> stream2 = Stream.of(4, 5);
        Stream<Integer> stream3 = Stream.of(7, 8);

        Stream<Integer> merged = Seq.ofType(stream1, Integer.class)
                .append(stream2)
                .append(stream3);

        merged.forEach(System.out::println);
    }

    public void mergeMultipleStreamsWithJoolAppendPrepend() {
        Stream<Integer> stream1 = Stream.of(4);
        Stream<Integer> stream2 = Stream.of(1, 2);
        Stream<Integer> stream3 = Stream.of(6, 7);

        Stream<Integer> merged = Seq.ofType(stream1, Integer.class)
                .append(stream3)
                .prepend(stream2);

        merged.forEach(System.out::println);
    }

    public static void main(String[] a) {
        MergeStreams mergeStreams = new MergeStreams();

        System.out.println("Merge Two Streams using Java concat()");
        mergeStreams.mergeTwoStreamsWithJavaConcat();

        System.out.println("Merge Multiple Streams using Java concat()");
        mergeStreams.mergeMultipleStreamsWithJavaConcat();

        System.out.println("Merge Multiple Streams using Java flatMap()");
        mergeStreams.mergeMultipleStreamsWithJavaFlatMap();

        System.out.println("Merge Multiple Streams using StreamEx append()");
        mergeStreams.mergeMultipleStreamsWithStreamExAppend();

        System.out.println("Merge Multiple Streams using StreamEx append(), prepend()");
        mergeStreams.mergeMultipleStreamsWithStreamExAppendPrepend();

        System.out.println("Merge Multiple Streams using jOOλ append()");
        mergeStreams.mergeMultipleStreamsWithJoolAppend();

        System.out.println("Merge Multiple Streams using jOOλ append(), prepend()");
        mergeStreams.mergeMultipleStreamsWithJoolAppendPrepend();
    }
}
