package com.apps;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberGeneratorTest {
    private PrimeNumberGenerator generator;

    @BeforeEach
    void setup() {
        generator = new PrimeNumberGenerator();
    }

    @Test
    void throwsIllegalArgumentExceptionIfNLessThan2() {
        assertThatThrownBy(() -> generator.generateUpTo(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generatesPrimeNumbersUpTo20() {
        assertThat(generator.generateUpTo(20))
                .isEqualTo(new int[]{2, 3, 5, 7, 11, 13, 17, 19});
    }

    @Test
    void generatesPrimeNumbersUpTo37() {
        assertThat(generator.generateUpTo(37))
                .isEqualTo(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37});
    }
}