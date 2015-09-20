package com.github.glomadrian.wallapopcodetest.app.di.module;

import com.github.glomadrian.wallapopcodetest.domain.repository.ComicRepository;
import com.github.glomadrian.wallapopcodetest.ui.comicinfo.presenter.ComicInfoPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Adrián García Lomas
 */
@Module
public class ComicInfoModule {

  @Provides
  public ComicInfoPresenter provideComicInfoPresenter(ComicRepository comicRepository) {
    return new ComicInfoPresenter(comicRepository);
  }
}
