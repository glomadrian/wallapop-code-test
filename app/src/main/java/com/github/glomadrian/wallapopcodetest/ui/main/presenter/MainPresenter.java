package com.github.glomadrian.wallapopcodetest.ui.main.presenter;

import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import com.github.glomadrian.wallapopcodetest.ui.Presenter;
import com.github.glomadrian.wallapopcodetest.ui.main.view.MainActivity;

/**
 * @author Adrián García Lomas
 */
public class MainPresenter extends Presenter<MainActivity> {
  private Navigator navigator;

  public MainPresenter(Navigator navigator) {
    this.navigator = navigator;
  }

  public void onGoToDetailAction() {
    navigator.goToDetailView();
  }
}
