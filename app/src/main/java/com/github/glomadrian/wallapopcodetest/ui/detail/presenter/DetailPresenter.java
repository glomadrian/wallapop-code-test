package com.github.glomadrian.wallapopcodetest.ui.detail.presenter;

import com.github.glomadrian.wallapopcodetest.ui.LifeCyclePresenter;
import com.github.glomadrian.wallapopcodetest.ui.detail.view.DetailView;

/**
 * @author Adrián García Lomas
 */
public class DetailPresenter extends LifeCyclePresenter<DetailView> {
  private boolean fistTime = true;

  public void onComicIdAvailable(int comidId) {
    if (fistTime) {
      fistTime = false;
      view.showComicInfoView(comidId);
    }
  }
}
