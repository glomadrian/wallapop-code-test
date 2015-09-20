package com.github.glomadrian.wallapopcodetest.ui.detail.view;

import com.github.glomadrian.wallapopcodetest.R;
import com.github.glomadrian.wallapopcodetest.app.AbstractActivity;
import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.detail.DaggerDetailViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.DetailViewModule;
import com.github.glomadrian.wallapopcodetest.ui.Presenter;
import com.github.glomadrian.wallapopcodetest.ui.detail.presenter.DetailPresenter;
import javax.inject.Inject;

/**
 * @author Adrián García Lomas
 */
public class DetailView extends AbstractActivity {

  @Inject protected DetailPresenter detailPresenter;

  @Override public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getApplication()).getApplicationComponent();
    return DaggerDetailViewComponent.builder()
        .applicationComponent(applicationComponent)
        .detailViewModule(new DetailViewModule())
        .build();
  }

  @Override public Presenter bindPresenter() {
    return detailPresenter;
  }

  @Override public int bindLayout() {
    return R.layout.detail_view;
  }
}
