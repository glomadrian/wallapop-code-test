package com.github.glomadrian.wallapopcodetest.ui.comics.presenter;

import android.util.Log;
import com.github.glomadrian.wallapopcodetest.domain.interactor.comics.GetComicsInteractor;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.ui.LifeCyclePresenter;
import com.github.glomadrian.wallapopcodetest.ui.comics.view.ComicsFragment;
import com.github.glomadrian.wallapopcodetest.utils.LogUtils;
import java.util.List;

/**
 * @author Adrián García Lomas
 */
public class ComicsPresenter extends LifeCyclePresenter<ComicsFragment> {

  private GetComicsInteractor getComicsInteractor;
  private ComicsCallback comicsCallback;

  public ComicsPresenter(GetComicsInteractor getComicsInteractor) {
    this.getComicsInteractor = getComicsInteractor;
    init();
  }

  private void init() {
    comicsCallback = new ComicsCallback();
  }

  @Override
  public void onViewReady() {
    super.onViewReady();
    fetchMoreComics();
  }

  private void fetchMoreComics() {
    view.showLoading();
    getComicsInteractor.execute(comicsCallback);
  }

  private class ComicsCallback implements GetComicsInteractor.ComicsInteractorCallback {

    @Override
    public void onComicsFetch(List<Comic> comicList) {
      Log.i(LogUtils.generateTag(this), "Received " + comicList.size() + "comics");
      view.hideLoading();
      view.showComics(comicList);
    }

    @Override
    public void onFetchError() {
      view.hideLoading();
      view.showError("Fetch Error");
    }
  }
}
