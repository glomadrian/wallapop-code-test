package com.github.glomadrian.wallapopcodetest.app.di.component.application;

import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.module.ApplicationModule;
import com.github.glomadrian.wallapopcodetest.app.executor.interactor.InteractorExecutor;
import com.github.glomadrian.wallapopcodetest.app.executor.main.MainThreadExecutor;
import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import dagger.Component;
import javax.inject.Singleton;

/**
 * The application component provide common dependencies to all sub-components
 *
 * @author Adrián García Lomas
 */
@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {

  void inject(MainApplication mainApplication);

  MainThreadExecutor mainThreadExecutor();

  InteractorExecutor interactorExecutor();

  Navigator navigator();
}
