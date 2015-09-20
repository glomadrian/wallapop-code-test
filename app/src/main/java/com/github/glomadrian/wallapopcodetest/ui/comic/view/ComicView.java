package com.github.glomadrian.wallapopcodetest.ui.comic.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import com.github.glomadrian.wallapopcodetest.R;
import com.github.glomadrian.wallapopcodetest.app.AdapterView;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.ui.Presenter;
import com.github.glomadrian.wallapopcodetest.ui.comic.presenter.ComicPresenter;
import javax.inject.Inject;

/**
 * @author Adrián García Lomas
 */
public class ComicView extends AdapterView {

  @Inject protected ComicPresenter comicPresenter;
  @Bind(R.id.name) TextView name;

  private Comic comic;

  public ComicView(Context context, ViewGroup viewGroup) {
    super(context, viewGroup);
  }

  public void render(Comic comic) {
    this.comic = comic;
    comicPresenter.onComicAvailable();
  }

  public void drawComic() {
    name.setText(comic.getTitle());
  }

  @Override
  public ViewComponent bindViewComponent() {
    return null;
  }

  @Override
  public Presenter bindPresenter() {
    return comicPresenter;
  }

  @Override
  public int bindLayout() {
    return R.layout.comic_view;
  }
}
