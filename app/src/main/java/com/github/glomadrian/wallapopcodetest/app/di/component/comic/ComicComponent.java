package com.github.glomadrian.wallapopcodetest.app.di.component.comic;

import com.github.glomadrian.wallapopcodetest.app.di.annotation.PerView;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.ui.comic.view.ComicView;
import dagger.Component;

/**
 * @author Adrián García Lomas
 */
@Component(dependencies = ApplicationComponent.class, modules = ComicModule.class)
@PerView
public class ComicComponent implements ViewComponent<ComicView> {
}
