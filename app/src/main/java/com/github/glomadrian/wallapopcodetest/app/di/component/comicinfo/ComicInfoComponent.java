package com.github.glomadrian.wallapopcodetest.app.di.component.comicinfo;

import com.github.glomadrian.wallapopcodetest.app.di.annotation.PerView;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.ComicInfoModule;
import com.github.glomadrian.wallapopcodetest.ui.comicinfo.view.ComicInfoFragment;
import dagger.Component;

/**
 * @author Adrián García Lomas
 */
@Component(dependencies = ApplicationComponent.class, modules = ComicInfoModule.class)
@PerView
public interface ComicInfoComponent extends ViewComponent<ComicInfoFragment> {
}
