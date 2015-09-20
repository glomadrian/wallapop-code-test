package com.github.glomadrian.wallapopcodetest.domain.mapper;

/**
 * Define a map
 *
 * @author Adrián García Lomas
 */
public interface Mapper<TFrom, TTo> {

  TTo map(TFrom from);
}
