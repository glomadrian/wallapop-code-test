package com.github.glomadrian.wallapopcodetest.ui.comic.presenter;

import com.github.glomadrian.wallapopcodetest.app.navigator.Navigator;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.ui.Presenter;
import com.github.glomadrian.wallapopcodetest.ui.comic.view.ComicView;

/**
 * @author Adrián García Lomas
 */
public class ComicPresenter extends Presenter<ComicView> {

  private Navigator navigator;

  public ComicPresenter(Navigator navigator) {
    this.navigator = navigator;
  }

  public void onComicAvailable() {
    view.drawComic();
  }

  public void onComicClicked(Comic comic) {
    navigator.goToDetailView(comic.getId());
  }
}
