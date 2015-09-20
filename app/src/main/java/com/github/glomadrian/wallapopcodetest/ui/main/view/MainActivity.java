package com.github.glomadrian.wallapopcodetest.ui.main.view;

import android.widget.Button;
import butterknife.Bind;
import butterknife.OnClick;
import com.github.glomadrian.wallapopcodetest.R;
import com.github.glomadrian.wallapopcodetest.app.AbstractActivity;
import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.main.DaggerMainViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.MainViewModule;
import com.github.glomadrian.wallapopcodetest.ui.Presenter;
import com.github.glomadrian.wallapopcodetest.ui.main.presenter.MainPresenter;
import javax.inject.Inject;

public class MainActivity extends AbstractActivity {

  @Inject protected MainPresenter mainPresenter;
  @Bind(R.id.detail_button) protected Button detailButton;

  @Override public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getApplication()).getApplicationComponent();
    return DaggerMainViewComponent.builder()
        .applicationComponent(applicationComponent)
        .mainViewModule(new MainViewModule())
        .build();
  }

  @Override public Presenter bindPresenter() {
    return mainPresenter;
  }

  @Override public int bindLayout() {
    return R.layout.activity_main;
  }

  @OnClick(R.id.detail_button) public void onDetailButtonClick() {
    mainPresenter.onGoToDetailAction();
  }
}
