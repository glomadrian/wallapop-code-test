package com.github.glomadrian.wallapopcodetest.domain.repository;

import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import java.util.List;

/**
 * @author Adrián García Lomas
 */
public interface ComicRepository {

  /**
   * Add a comic to the repository
   */
  void add(Comic comic);

  /**
   * Add a complete list to the comic repository
   */
  void add(List<Comic> comics);

  /**
   * Get all actual comics available on the repository
   */
  List<Comic> getAll();

  /**
   * Find a comic by id inside the repository
   */
  Comic findById(int id);

  /**
   * Get more comics from the data store
   */
  List<Comic> fetch();

  /**
   * Get more comics from the data store with amount
   */
  List<Comic> fetch(int amount);

  /**
   * Remove all stored comics in the repository
   */
  void erase();

  /**
   * Checks if the repository is empty
   */
  boolean isEmpty();
}
