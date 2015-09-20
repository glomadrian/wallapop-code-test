package com.github.glomadrian.wallapopcodetest.ui.comic.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.OnClick;
import com.github.glomadrian.wallapopcodetest.R;
import com.github.glomadrian.wallapopcodetest.app.AdapterView;
import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.provider.ComponentProvider;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.ui.Presenter;
import com.github.glomadrian.wallapopcodetest.ui.comic.presenter.ComicPresenter;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

/**
 * @author Adrián García Lomas
 */
public class ComicView extends AdapterView {

  @Inject protected ComicPresenter comicPresenter;
  @Bind(R.id.thumbnail) protected ImageView thumbnail;

  private Comic comic;

  public ComicView(Context context, ViewGroup viewGroup) {
    super(context, viewGroup);
  }

  public void render(Comic comic) {
    this.comic = comic;
    comicPresenter.onComicAvailable();
  }

  public void drawComic() {
    Picasso.with(context)
        .load(comic.getThumbnailUrl())
        .placeholder(R.drawable.placeholder)
        .into(thumbnail);
  }

  @Override
  public ViewComponent bindViewComponent(Context context) {
    ApplicationComponent applicationComponent =
        ((MainApplication) context.getApplicationContext()).getApplicationComponent();
    return ComponentProvider.getComicComponent(applicationComponent);
  }

  @Override
  public Presenter bindPresenter() {
    return comicPresenter;
  }

  @Override
  public int bindLayout() {
    return R.layout.comic_view;
  }

   @OnClick(R.id.thumbnail)
  public void onThumbnailCLick(){
     comicPresenter.onComicClicked(comic);
   }
}
