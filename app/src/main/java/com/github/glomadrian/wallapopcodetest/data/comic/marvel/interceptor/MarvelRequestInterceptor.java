package com.github.glomadrian.wallapopcodetest.data.comic.marvel.interceptor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import retrofit.RequestInterceptor;

/**
 * Interceptor to add the auth key, and generate the hash for every request
 * The data is exposed in the constructor
 *
 * @author glomadrian
 */
public class MarvelRequestInterceptor implements RequestInterceptor {

  public static final String PARAM_KEY = "apikey";
  public static final String PARAM_TIMESTAMP = "ts";
  public static final String PARAM_HASH = "hash";
  private static final int SIGNUM = 1;
  private static final int BYTES = 1;
  private String publicKey;
  private String privateKey;

  public MarvelRequestInterceptor(String publicKey, String privateKey) {
    this.publicKey = publicKey;
    this.privateKey = privateKey;
  }

  @Override
  public void intercept(RequestFacade request) {
    long timeStamp = System.currentTimeMillis();
    request.addEncodedQueryParam(PARAM_TIMESTAMP, String.valueOf(timeStamp));
    request.addEncodedQueryParam(PARAM_KEY, publicKey);
    String hash = generateMarvelHash(timeStamp, privateKey, publicKey);
    request.addEncodedQueryParam(PARAM_HASH, hash);
  }

  private String generateMarvelHash(long timeStamp, String privateKey, String publicKey) {
    String marvelHash = timeStamp + privateKey + publicKey;
    return md5(marvelHash);
  }

  /**
   * MD5 digest obtained from http://stackoverflow.com/a/4846511
   */
  public static final String md5(final String s) {
    final String MD5 = "MD5";
    try {
      // Create MD5 Hash
      MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
      digest.update(s.getBytes());
      byte messageDigest[] = digest.digest();

      // Create Hex String
      StringBuilder hexString = new StringBuilder();
      for (byte aMessageDigest : messageDigest) {
        String h = Integer.toHexString(0xFF & aMessageDigest);
        while (h.length() < 2) {
          h = "0" + h;
        }
        hexString.append(h);
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}
