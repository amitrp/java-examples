package com.amitph.java.streams;

import static java.util.stream.Collectors.toList;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ElementAppender {
    public <T> Stream<T> appendElement(Stream<T> stream, T newElement) {
        return Stream.concat(stream, Stream.of(newElement));
    }

    public <T> Stream<T> prependElement(Stream<T> stream, T newElement) {
        return Stream.concat(Stream.of(newElement), stream);
    }

    public <T> Stream<T> insertElement_usingList(Stream<T> stream, T newElement, int index) {
        List<T> list = stream.collect(toList());
        list.add(index, newElement);
        return list.stream();
    }

    public <T> Stream<T> insertElement_usingSpliterator(Stream<T> stream, T newElement, int index) {
        Spliterator<T> spliterator = stream.spliterator();

        Iterator<T> iterator = Spliterators.iterator(spliterator);

        Stream<T> stream1 =
                Stream.concat(Stream.generate(iterator::next).limit(index), Stream.of(newElement));
        Stream<T> stream2 = StreamSupport.stream(spliterator, false);

        return Stream.concat(stream1, stream2);
    }

    public static void main(String[] args) {
        ElementAppender elementAppender = new ElementAppender();

        System.out.println("Append an element to Stream");
        elementAppender.appendElement(Stream.of(1, 2, 6, 7), 8).forEach(System.out::println);

        System.out.println("Prepend an element to Stream");
        elementAppender.prependElement(Stream.of(1, 2, 6, 7), 0).forEach(System.out::println);

        System.out.println("Insert an element in a Stream using List");
        elementAppender
                .insertElement_usingList(Stream.of(1, 2, 6, 7), 3, 2)
                .forEach(System.out::println);

        System.out.println("Insert an element in a Stream using Spliterator");
        elementAppender
                .insertElement_usingSpliterator(Stream.of(1, 2, 6, 7), 3, 2)
                .forEach(System.out::println);
    }
}
