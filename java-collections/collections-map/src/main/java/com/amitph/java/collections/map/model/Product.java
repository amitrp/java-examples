package com.amitph.java.collections.map.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Comparable<Product> {
    private Long id;
    private String name;

    public int compareTo(Product product) {
        return name.compareTo(product.name);
    }
}