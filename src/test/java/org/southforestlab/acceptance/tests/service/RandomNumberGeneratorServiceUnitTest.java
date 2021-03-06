package org.southforestlab.acceptance.tests.service;

import org.junit.jupiter.api.Test;
import org.southforestlab.acceptance.service.RandomNumberGeneratorService;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorServiceUnitTest {

    private final RandomNumberGeneratorService tested = new RandomNumberGeneratorService();

    @Test
    public void generateRandomNumberReturnsOK() {

        int actual = tested.generateRandomNumber(1,5);
        assertTrue(actual>=1 && actual<=5);
    }
}