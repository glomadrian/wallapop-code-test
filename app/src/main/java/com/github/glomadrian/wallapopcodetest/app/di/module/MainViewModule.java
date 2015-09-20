package com.github.glomadrian.wallapopcodetest.app.di.module;

import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import com.github.glomadrian.wallapopcodetest.ui.main.presenter.MainPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Adrián García Lomas
 */
@Module public class MainViewModule {

  @Provides MainPresenter provideMainPresenter(Navigator navigator) {
    return new MainPresenter(navigator);
  }
}
