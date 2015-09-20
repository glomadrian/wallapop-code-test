package com.github.glomadrian.wallapopcodetest.ui.main.presenter;

import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import com.github.glomadrian.wallapopcodetest.ui.LifeCyclePresenter;
import com.github.glomadrian.wallapopcodetest.ui.main.view.MainActivity;

/**
 * @author Adrián García Lomas
 */
public class MainPresenter extends LifeCyclePresenter<MainActivity> {
  private Navigator navigator;

  public MainPresenter(Navigator navigator) {
    this.navigator = navigator;
  }

  public void onGoToDetailAction() {
    navigator.goToDetailView();
  }

  @Override
  public void onResume() {
    super.onResume();
    view.showComicsView();
  }
}
