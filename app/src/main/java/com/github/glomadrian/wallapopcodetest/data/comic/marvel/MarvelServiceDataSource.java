package com.github.glomadrian.wallapopcodetest.data.comic.marvel;

import com.github.glomadrian.wallapopcodetest.data.comic.ComicDataSource;
import com.github.glomadrian.wallapopcodetest.data.comic.exception.ComicsNotFoundException;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.interceptor.MarvelRequestInterceptor;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.ComicsResponse;
import com.github.glomadrian.wallapopcodetest.domain.mapper.MarvelResponseToComicsMapper;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.google.gson.Gson;
import java.util.List;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;

/**
 * Custom implementation of Comic Data Source using retrofit
 *
 * @author Adrián García Lomas
 */
public class MarvelServiceDataSource implements ComicDataSource {

  private MarvelService marvelService;
  private String baseUrl;
  private String publicKey;
  private String privateKey;
  private MarvelResponseToComicsMapper marvelResponseToComicsMapper;

  public MarvelServiceDataSource(String baseUrl, String publicKey, String privateKey) {
    this.baseUrl = baseUrl;
    this.publicKey = publicKey;
    this.privateKey = privateKey;
    init();
  }

  private void init() {
    buildRetrofitMarvelService();
    buildMarvelResponseMapper();
  }

  private void buildRetrofitMarvelService() {

    RestAdapter restAdapter =
        new RestAdapter.Builder().setRequestInterceptor(buildMarvenRequestInterceptor())
            .setConverter(new GsonConverter(new Gson()))
            .setEndpoint(baseUrl)
            .build();
    marvelService = restAdapter.create(MarvelService.class);
  }

  private void buildMarvelResponseMapper() {
    marvelResponseToComicsMapper = new MarvelResponseToComicsMapper();
  }

  private MarvelRequestInterceptor buildMarvenRequestInterceptor() {
    return new MarvelRequestInterceptor(publicKey, privateKey);
  }

  @Override
  public List<Comic> getComics(int limit, int characterId) throws ComicsNotFoundException {
    try {
      ComicsResponse marvelResult = marvelService.getComics(limit, characterId);
      return marvelResponseToComicsMapper.map(marvelResult);
    } catch (RetrofitError error) {
      ComicsNotFoundException comicsNotFoundException = new ComicsNotFoundException();
      comicsNotFoundException.setStackTrace(error.getStackTrace());
      throw comicsNotFoundException;
    }
  }

  @Override
  public List<Comic> getComics(int limit, int offset, int characterId)
      throws ComicsNotFoundException {
    try {
      ComicsResponse marvelResult = marvelService.getComics(limit, offset, characterId);
      return marvelResponseToComicsMapper.map(marvelResult);
    } catch (RetrofitError error) {
      ComicsNotFoundException comicsNotFoundException = new ComicsNotFoundException();
      comicsNotFoundException.setStackTrace(error.getStackTrace());
      throw comicsNotFoundException;
    }
  }
}
