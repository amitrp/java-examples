package com.amitph.java.streams;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberStream {
    public static void main(String[] a) throws NoSuchAlgorithmException {
        Random random = new Random();

        System.out.println("Infinite Stream of Random Integers");
        random.ints()
                .limit(7)
                .forEach(System.out::print);

        System.out.println();
        System.out.println("Infinite Stream of Random Doubles");
        random.doubles()
                .limit(7)
                .forEach(System.out::print);

        System.out.println();
        System.out.println("Infinite Stream of Random Longs");
        random.longs()
                .limit(7)
                .forEach(System.out::print);

        System.out.println();
        System.out.println("Infinite Stream of Secure Random Integers");
        SecureRandom.getInstanceStrong().ints()
                .limit(7)
                .forEach(System.out::print);

        System.out.println();
        System.out.println("Infinite Stream of Secure Random Doubles");
        SecureRandom.getInstanceStrong().doubles()
                .limit(3)
                .forEach(System.out::print);

        System.out.println();
        System.out.println("Infinite Stream of Secure Random Longs");
        SecureRandom.getInstanceStrong().longs()
                .limit(4)
                .forEach(System.out::print);
    }
}