package com.github.glomadrian.wallapopcodetest.app.di.component.detail;

import com.github.glomadrian.wallapopcodetest.app.di.annotation.PerView;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.DetailViewModule;
import com.github.glomadrian.wallapopcodetest.ui.detail.view.DetailView;
import dagger.Component;

/**
 * @author Adrián García Lomas
 */
@Component(dependencies = ApplicationComponent.class, modules = DetailViewModule.class) @PerView
public interface DetailViewComponent extends ViewComponent<DetailView> {

  @Override void inject(DetailView detailView);
}
