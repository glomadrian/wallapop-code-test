package com.github.glomadrian.wallapopcodetest.domain.mapper;

import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.ComicsResponse;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.Result;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrián García Lomas
 */
public class MarvelResponseToComicsMapper implements Mapper<ComicsResponse, List<Comic>> {

  private MarvelResultToComicMapper marvelResultToComicMapper;

  public MarvelResponseToComicsMapper() {
    init();
  }

  private void init() {
    marvelResultToComicMapper = new MarvelResultToComicMapper();
  }

  @Override
  public List<Comic> map(ComicsResponse comicsResponse) {
    List<Comic> comics = new ArrayList<>();
    for (Result result : comicsResponse.getData().getResults()) {
      Comic mappedComic = marvelResultToComicMapper.map(result);
      comics.add(mappedComic);
    }
    return comics;
  }
}
