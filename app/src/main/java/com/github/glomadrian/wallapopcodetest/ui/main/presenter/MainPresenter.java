package com.github.glomadrian.wallapopcodetest.ui.main.presenter;

import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import com.github.glomadrian.wallapopcodetest.domain.repository.ComicRepository;
import com.github.glomadrian.wallapopcodetest.ui.LifeCyclePresenter;
import com.github.glomadrian.wallapopcodetest.ui.main.view.MainActivity;

/**
 * @author Adrián García Lomas
 */
public class MainPresenter extends LifeCyclePresenter<MainActivity> {

  private Navigator navigator;
  private boolean fistTime = true;
  private ComicRepository comicRepository;

  public MainPresenter(Navigator navigator, ComicRepository comicRepository) {
    this.navigator = navigator;
    this.comicRepository = comicRepository;
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  @Override
  public void onViewReady() {
    super.onViewReady();
    if (fistTime) {
      fistTime = false;
      view.showComicsView();
    }
  }

  public void onPortrait() {
    //Empty
  }

  public void onLandScape() {
    if (!comicRepository.isEmpty()) {
      view.showComicInfoView(comicRepository.getAll().get(0).getId());
    }
  }
}
