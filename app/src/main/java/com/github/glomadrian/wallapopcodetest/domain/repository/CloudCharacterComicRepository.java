package com.github.glomadrian.wallapopcodetest.domain.repository;

import android.content.res.Resources;
import com.github.glomadrian.wallapopcodetest.data.comic.ComicDataSource;
import com.github.glomadrian.wallapopcodetest.data.comic.exception.ComicsNotFoundException;
import com.github.glomadrian.wallapopcodetest.domain.model.Character;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.utils.AssertUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a synchronous implementation of a ComicRepository to use with a cloud source, it use the
 * data source to get comics
 * This Repository must be used from other thread (Interactor) not from the UI Thread
 *
 * @author Adrián García Lomas
 */
public class CloudCharacterComicRepository implements ComicRepository {

  private static final int DEFAULT_FETCH_AMOUNT = 10;
  private HashMap<Integer, Comic> comicHashMap;
  private ComicDataSource comicDataSource;
  private Character character;

  public CloudCharacterComicRepository(ComicDataSource comicDataSource) {
    this.comicDataSource = comicDataSource;
    init();
  }

  private void init() {
    comicHashMap = new HashMap<>();
  }

  public void initialize(Character character) {
    this.character = character;
  }

  @Override
  public void add(Comic comic) {
    comicHashMap.put(comic.getId(), comic);
  }

  @Override
  public void add(List<Comic> comics) {
    for (Comic comic : comics) {
      add(comic);
    }
  }

  @Override
  public List<Comic> getAll() {
    return new ArrayList<>(comicHashMap.values());
  }

  @Override
  public Comic findById(int id) {
    if (comicHashMap.containsKey(id)) {
      return comicHashMap.get(id);
    } else {
      throw new Resources.NotFoundException();
    }
  }

  @Override
  public List<Comic> fetch() {
    return fetch(DEFAULT_FETCH_AMOUNT);
  }

  @Override
  public List<Comic> fetch(int amount) {
    assertRepositoryInitialize();
    try {
      List<Comic> comics =
          comicDataSource.getComics(amount, comicHashMap.size(), character.getId());
      add(comics);
      return comics;
    } catch (ComicsNotFoundException e) {
      throw new Resources.NotFoundException();
    }
  }

  @Override
  public void erase() {
    comicHashMap.clear();
  }

  @Override
  public boolean isEmpty() {
    return comicHashMap.isEmpty();
  }

  private void assertRepositoryInitialize() {
    AssertUtils.assertThis(character != null, "You must set a character before fech",
        this.getClass());
  }
}
