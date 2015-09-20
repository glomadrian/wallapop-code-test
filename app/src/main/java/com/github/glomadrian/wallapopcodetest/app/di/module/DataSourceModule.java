package com.github.glomadrian.wallapopcodetest.app.di.module;

import com.github.glomadrian.wallapopcodetest.data.comic.ComicDataSource;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.MarvelServiceDataSource;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Adrián García Lomas
 */
@Module
public class DataSourceModule {

  @Provides
  @Named("marvel_endpoint")
  public String provideMarvelEndpoint() {
    return "http://gateway.marvel.com";
  }

  @Provides
  @Named("marvel_public_api_key")
  public String provideMarvelPublicKey() {
    return "3a39768d38da927248f7ed89477e9ff6";
  }

  @Provides
  @Named("marvel_private_api_key")
  public String provideMarvelPrivateKey() {
    return "b80e34966642c6bf0d1b47b389462ee0a6b2d822";
  }

  @Provides
  @Singleton
  public ComicDataSource provideComicDataSource(@Named("marvel_endpoint") String endpoint,
      @Named("marvel_public_api_key") String publicKey,
      @Named("marvel_private_api_key") String privateKey) {
    return new MarvelServiceDataSource(endpoint, publicKey, privateKey);
  }
}
