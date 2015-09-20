package com.github.glomadrian.wallapopcodetest.data.comic;

import com.github.glomadrian.wallapopcodetest.data.comic.exception.ComicsNotFoundException;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import java.util.List;

/**
 * Define how a Comic data sourve should be implemented
 *
 * @author Adrián García Lomas
 */
public interface ComicDataSource {

  List<Comic> getComics(int limit, int characterId) throws ComicsNotFoundException;

  List<Comic> getComics(int limit, int offset, int characterId) throws ComicsNotFoundException;
}
