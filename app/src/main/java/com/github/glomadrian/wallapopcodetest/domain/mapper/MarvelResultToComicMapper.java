package com.github.glomadrian.wallapopcodetest.domain.mapper;

import android.util.Log;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.Result;
import com.github.glomadrian.wallapopcodetest.domain.mapper.exception.DataNotFoundException;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.utils.LogUtils;

/**
 * @author Adrián García Lomas
 */
public class MarvelResultToComicMapper implements Mapper<Result, Comic> {

  @Override
  public Comic map(Result result) {
    Comic comic = new Comic();
    try {
      comic.setTitle(obtainTitle(result));
      comic.setThumbnailUrl(obtainThumbnail(result));
      comic.setDescription(obtainDescription(result));
    } catch (DataNotFoundException e) {
      Log.w(LogUtils.generateTag(this), "Some data not found result");
    }
    return comic;
  }

  private String obtainTitle(Result result) throws DataNotFoundException {
    if (result.getTitle() != null) {
      return result.getTitle();
    } else {
      throw new DataNotFoundException();
    }
  }

  private String obtainThumbnail(Result result) throws DataNotFoundException {
    return result.getThumbnail().getPath();
  }

  private String obtainDescription(Result result) throws DataNotFoundException {
    return result.getDescription();
  }
}
