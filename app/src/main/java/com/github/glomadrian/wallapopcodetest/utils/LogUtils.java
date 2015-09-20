package com.github.glomadrian.wallapopcodetest.utils;

/**
 * @author glomadrian
 */
public final class LogUtils {

  private LogUtils() {
    //No instances allowed
  }

  public static String generateTag(Object object) {
    return object.getClass().getCanonicalName();
  }
}
