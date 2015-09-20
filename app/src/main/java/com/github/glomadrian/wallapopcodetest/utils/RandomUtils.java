package com.github.glomadrian.wallapopcodetest.utils;

import java.util.Random;

/**
 * @author Adrián García Lomas
 */
public final class RandomUtils {

  private RandomUtils() {
    //No instances allowed
  }

  public static int getRandomNumber(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }
}
