package com.github.glomadrian.wallapopcodetest.app.di.module;

import android.content.Context;
import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.executor.interactor.DefaultInteractorExecutor;
import com.github.glomadrian.wallapopcodetest.app.executor.interactor.InteractorExecutor;
import com.github.glomadrian.wallapopcodetest.app.executor.main.MainThreadExecutor;
import com.github.glomadrian.wallapopcodetest.app.executor.main.MainThreadExecutorImp;
import com.github.glomadrian.wallapopcodetest.app.navigator.DefaultNavigator;
import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * The application module is the base module, is create on the Application start,
 * and the context is passed on the constructor, made it available for all modules
 *
 * @author Adrián García Lomas
 */
@Module public class ApplicationModule {

  private final MainApplication application;

  public ApplicationModule(MainApplication mainApplication) {
    this.application = mainApplication;
  }

  @Provides @Singleton public MainThreadExecutor provideMainThreadExecutor() {
    return new MainThreadExecutorImp();
  }

  @Provides @Singleton public InteractorExecutor provideInteractorExecutor() {
    return new DefaultInteractorExecutor();
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton Navigator provideNavigator() {
    return new DefaultNavigator();
  }
}
