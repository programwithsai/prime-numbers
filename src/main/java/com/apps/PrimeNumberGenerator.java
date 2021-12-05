package com.apps;

import java.util.stream.IntStream;

public class PrimeNumberGenerator {
    public int[] generateUpTo(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("n must be greater than 1");
        }

        boolean[] isPrime = new boolean[n + 1];

        IntStream.range(2, n + 1)
                .forEach(i -> isPrime[i] = true);

        int bound = isPrime.length / 2;
        for (int i = 2; i < bound; i++) {
            if (isPrime[i] == true) {
                for (int j = i + i; j < isPrime.length;) {
                    isPrime[j] = false;
                    j = j + i;
                }
            }
        }

        int count = (int)IntStream.range(0, isPrime.length)
                .filter(i -> isPrime[i])
                .count();

        int[] primes = new int[count];
        for (int i = 0, j = 0; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                primes[j++] = i;
            }
        }
        return primes;
    }
}
