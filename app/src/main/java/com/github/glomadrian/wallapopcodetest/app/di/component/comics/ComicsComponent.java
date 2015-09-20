package com.github.glomadrian.wallapopcodetest.app.di.component.comics;

import com.github.glomadrian.wallapopcodetest.app.di.annotation.PerView;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.ComicsModule;
import com.github.glomadrian.wallapopcodetest.ui.comics.view.ComicsFragment;
import dagger.Component;

/**
 * @author Adrián García Lomas
 */
@Component(dependencies = ApplicationComponent.class, modules = ComicsModule.class)
@PerView
public interface ComicsComponent extends ViewComponent<ComicsFragment> {

}
