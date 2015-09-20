package com.github.glomadrian.wallapopcodetest.data.comic.marvel;

import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.ComicsResponse;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * @author Adrián García Lomas
 */
public interface MarvelService {

  @GET("/v1/public/characters/{characterId}/comics")
  ComicsResponse getComics(@Query("limit") int limit, @Path("characterId") int characterId);

  @GET("/v1/public/characters/{characterId}/comics")
  ComicsResponse getComics(@Query("limit") int limit, @Query("offset") int offset,
      @Path("characterId") int characterId);
}
