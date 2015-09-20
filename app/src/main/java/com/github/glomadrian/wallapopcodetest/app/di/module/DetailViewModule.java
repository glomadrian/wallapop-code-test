package com.github.glomadrian.wallapopcodetest.app.di.module;

import com.github.glomadrian.wallapopcodetest.ui.detail.presenter.DetailPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Adrián García Lomas
 */
@Module public class DetailViewModule {

  @Provides public DetailPresenter provideDetailPresenter() {
    return new DetailPresenter();
  }
}
