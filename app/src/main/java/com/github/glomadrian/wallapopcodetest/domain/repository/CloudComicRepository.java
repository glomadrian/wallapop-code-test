package com.github.glomadrian.wallapopcodetest.domain.repository;

import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
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
public class CloudComicRepository implements ComicRepository {

  private HashMap<Integer, Comic> comicHashMap;

  public CloudComicRepository() {
    comicHashMap = new HashMap<>();
  }

  @Override public void add(Comic comic) {
    comicHashMap.put(comic.getId(), comic);
  }

  @Override public void add(List<Comic> comics) {
    for (Comic comic : comics) {
      add(comic);
    }
  }

  @Override public List<Comic> getAll() {
    return new ArrayList<>(comicHashMap.values());
  }

  @Override public Comic findById(int id) {
    //TODO implement
    return null;
  }

  @Override public List<Comic> fetch() {
    //TODO implement
    return null;
  }

  @Override public void erase() {
    comicHashMap.clear();
  }

  @Override public boolean isEmpty() {
    return comicHashMap.isEmpty();
  }
}
