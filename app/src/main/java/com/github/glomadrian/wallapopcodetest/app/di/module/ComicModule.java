package com.github.glomadrian.wallapopcodetest.app.di.module;

import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import com.github.glomadrian.wallapopcodetest.ui.comic.presenter.ComicPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Adrián García Lomas
 */
@Module
public class ComicModule {

  @Provides
  public ComicPresenter provideComicPresenter(Navigator navigator) {
    return new ComicPresenter(navigator);
  }
}
