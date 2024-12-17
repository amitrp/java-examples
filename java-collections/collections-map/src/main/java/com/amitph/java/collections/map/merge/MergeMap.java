package com.amitph.java.collections.map.merge;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeMap {
    private final Map<Integer, String> map1 =
            Map.of(
                    1, "Ned",
                    2, "Jon",
                    3, "Khal");

    private final Map<Integer, String> map2 =
            Map.of(
                    1, "Tywin",
                    2, "Jon",
                    4, "Petyr");

    private void usingStreamOf() {
        System.out.println("merge usingStreamOf");

        Map<Integer, String> map3 =
                Stream.of(map1, map2)
                        .flatMap(map -> map.entrySet().stream())
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (value1, value2) -> value1));

        System.out.println(map3);
    }

    private void usingStreamConcat() {
        System.out.println("merge usingStreamConcat");

        Map<Integer, String> map3 =
                Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1));

        System.out.println(map3);
    }

    private void usingMapPutAll() {
        System.out.println("merge usingMapPutAll");

        Map<Integer, String> map3 = new HashMap<>();
        map3.putAll(map1);
        map3.putAll(map2);
        System.out.println(map3);
    }

    private void usingMapMerge() {
        System.out.println("merge usingMapMerge");

        Map<Integer, String> map3 = new HashMap<>(map1);
        map2.forEach((key, value) -> map3.merge(key, value, (value1, value2) -> value1));
        System.out.println(map3);
    }

    public static void main(String[] a) {
        MergeMap mergeMaps = new MergeMap();

        mergeMaps.usingStreamOf();
        mergeMaps.usingStreamConcat();
        mergeMaps.usingMapPutAll();
        mergeMaps.usingMapMerge();
    }
}
