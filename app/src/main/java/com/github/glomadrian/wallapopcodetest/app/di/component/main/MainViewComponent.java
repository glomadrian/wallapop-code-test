package com.github.glomadrian.wallapopcodetest.app.di.component.main;

import com.github.glomadrian.wallapopcodetest.app.di.annotation.PerView;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.MainViewModule;
import com.github.glomadrian.wallapopcodetest.ui.main.view.MainActivity;
import dagger.Component;

/**
 * @author Adrián García Lomas
 */
@Component(dependencies = ApplicationComponent.class, modules = MainViewModule.class) @PerView
public interface MainViewComponent extends ViewComponent<MainActivity> {

  @Override void inject(MainActivity mainView);
}
