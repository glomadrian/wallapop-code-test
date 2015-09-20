package com.github.glomadrian.wallapopcodetest.app.executor;

/**
 * Interface for create a executor
 *
 * @author Adrián García Lomas
 */
public interface Executor<T extends Runnable> {

  void execute(T runnable);
}
