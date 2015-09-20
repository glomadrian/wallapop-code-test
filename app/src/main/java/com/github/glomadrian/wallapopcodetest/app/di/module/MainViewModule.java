package com.github.glomadrian.wallapopcodetest.app.di.module;

import com.github.glomadrian.wallapopcodetest.app.di.annotation.PerView;
import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import com.github.glomadrian.wallapopcodetest.domain.repository.ComicRepository;
import com.github.glomadrian.wallapopcodetest.ui.main.presenter.MainPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Adrián García Lomas
 */
@Module
public class MainViewModule {

  @Provides
  @PerView
  MainPresenter provideMainPresenter(Navigator navigator, ComicRepository comicRepository) {
    return new MainPresenter(navigator, comicRepository);
  }
}
