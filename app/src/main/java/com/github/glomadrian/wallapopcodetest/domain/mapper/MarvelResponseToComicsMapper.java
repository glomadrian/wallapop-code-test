package com.github.glomadrian.wallapopcodetest.domain.mapper;

import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.ComicsResponse;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.Result;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import java.util.ArrayList;
import java.util.List;

/**
 * Map beetween the marvel api domain and application domain, this is very important, if the data
 * changes in the marvel api, there is not need to change the application model, also the
 * application  model can be use with others apis
 *
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
