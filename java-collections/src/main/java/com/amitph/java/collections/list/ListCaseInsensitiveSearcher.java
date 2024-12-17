package com.amitph.java.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListCaseInsensitiveSearcher {
    private final List<String> list = List.of("Ray", "Leo", "Bee", "Tim");

    public void usingStreams() {
        boolean contains = list.stream().anyMatch(x -> x.equalsIgnoreCase("raY"));
        System.out.println(contains);
    }

    public void usingUtilityMethod() {
        boolean contains = ListCaseInsensitiveSearcher.searchIgnoringCase(list, "lEo");
        System.out.println(contains);
    }

    public void usingOverriddenContains() {
        List<String> customList = new CaseInsensitiveArrayList(list);

        System.out.println(customList.contains("raY"));

        System.out.println(customList.containsAll(List.of("ray", "bEE", "tIm")));
    }

    public static boolean searchIgnoringCase(List<String> list, String text) {
        for (String s : list) {
            if (s.equalsIgnoreCase(text)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] a) {
        ListCaseInsensitiveSearcher searcher = new ListCaseInsensitiveSearcher();

        System.out.println("Using Java Streams");
        searcher.usingStreams();

        System.out.println("Using Util Method");
        searcher.usingUtilityMethod();

        System.out.println("Using Custom List - overriding the contains()");
        searcher.usingOverriddenContains();
    }
}

class CaseInsensitiveArrayList extends ArrayList<String> {
    public CaseInsensitiveArrayList(Collection<String> c) {
        super(c);
    }

    @Override
    public boolean contains(Object o) {
        String text = (String) o;
        return this.stream().anyMatch(x -> x.equalsIgnoreCase(text));
    }
}
