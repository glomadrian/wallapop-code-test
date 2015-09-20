package com.github.glomadrian.wallapopcodetest.ui.comic.presenter;

import com.github.glomadrian.wallapopcodetest.ui.Presenter;
import com.github.glomadrian.wallapopcodetest.ui.comic.view.ComicView;

/**
 * @author Adrián García Lomas
 */
public class ComicPresenter extends Presenter<ComicView> {

  public void onComicAvailable() {
    view.drawComic();
  }
}
