package com.github.glomadrian.wallapopcodetest.app.di.component.application;

import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.module.ApplicationModule;
import com.github.glomadrian.wallapopcodetest.app.di.module.DataSourceModule;
import com.github.glomadrian.wallapopcodetest.app.di.module.RepositoryModule;
import com.github.glomadrian.wallapopcodetest.app.executor.interactor.InteractorExecutor;
import com.github.glomadrian.wallapopcodetest.app.executor.main.MainThreadExecutor;
import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import com.github.glomadrian.wallapopcodetest.domain.repository.ComicRepository;
import dagger.Component;
import javax.inject.Singleton;

/**
 * The application component provide common dependencies to all sub-components
 *
 * @author Adrián García Lomas
 */
@Singleton
@Component(modules = { ApplicationModule.class, RepositoryModule.class, DataSourceModule.class })
public interface ApplicationComponent {

  void inject(MainApplication mainApplication);

  MainThreadExecutor mainThreadExecutor();

  InteractorExecutor interactorExecutor();

  Navigator navigator();

  ComicRepository comicRepository();
}
