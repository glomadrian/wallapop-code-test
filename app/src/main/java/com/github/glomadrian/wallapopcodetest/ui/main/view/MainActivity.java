package com.github.glomadrian.wallapopcodetest.ui.main.view;

import android.widget.FrameLayout;
import butterknife.Bind;
import com.github.glomadrian.wallapopcodetest.R;
import com.github.glomadrian.wallapopcodetest.app.AbstractActivity;
import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.main.DaggerMainViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.MainViewModule;
import com.github.glomadrian.wallapopcodetest.ui.LifeCyclePresenter;
import com.github.glomadrian.wallapopcodetest.ui.comics.view.ComicsFragment;
import com.github.glomadrian.wallapopcodetest.ui.main.presenter.MainPresenter;
import javax.inject.Inject;

public class MainActivity extends AbstractActivity {

  @Inject protected MainPresenter mainPresenter;
  @Bind(R.id.comics_frame) protected FrameLayout charactersFrame;

  @Override
  public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getApplication()).getApplicationComponent();
    return DaggerMainViewComponent.builder()
        .applicationComponent(applicationComponent)
        .mainViewModule(new MainViewModule())
        .build();
  }

  @Override
  public LifeCyclePresenter bindPresenter() {
    return mainPresenter;
  }

  @Override
  public int bindLayout() {
    return R.layout.activity_main;
  }

  public void showComicsView() {
    ComicsFragment comicsFragment = ComicsFragment.newInstance();
    getSupportFragmentManager().beginTransaction().add(R.id.comics_frame, comicsFragment).commit();
  }
}
