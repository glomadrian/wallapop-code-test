package com.github.glomadrian.wallapopcodetest.ui.comicinfo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import com.github.glomadrian.wallapopcodetest.R;
import com.github.glomadrian.wallapopcodetest.app.AbstractFragment;
import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.provider.ComponentProvider;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.ui.LifeCyclePresenter;
import com.github.glomadrian.wallapopcodetest.ui.comicinfo.presenter.ComicInfoPresenter;
import com.github.glomadrian.wallapopcodetest.ui.custom.TriangleImageView;
import com.github.glomadrian.wallapopcodetest.utils.LogUtils;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

/**
 * @author Adrián García Lomas
 */
public class ComicInfoFragment extends AbstractFragment {

  public static final String COMIC_ID = "comicId";
  @Inject protected ComicInfoPresenter comicInfoPresenter;
  @Bind(R.id.header_image) protected TriangleImageView triangleImageView;
  @Bind(R.id.title) protected TextView title;
  @Bind(R.id.year) protected TextView year;
  @Bind(R.id.description) protected TextView description;
  @Bind(R.id.no_character) protected TextView noCharacter;

  @Override
  public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getActivity().getApplication()).getApplicationComponent();
    return ComponentProvider.getComicInfoComponent(applicationComponent);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    if (getArguments() != null) {
      int comicId = getArguments().getInt(COMIC_ID);
      comicInfoPresenter.onComicIdAvailable(comicId);
    }
  }

  @Override
  public LifeCyclePresenter bindPresenter() {
    return comicInfoPresenter;
  }

  @Override
  public int bindLayout() {
    return R.layout.comic_info_view;
  }

  public static ComicInfoFragment newInstance(int comicId) {
    Bundle args = new Bundle();
    args.putInt(COMIC_ID, comicId);
    ComicInfoFragment comicInfoFragment = new ComicInfoFragment();
    comicInfoFragment.setArguments(args);
    return comicInfoFragment;
  }

  public void draw(Comic comic) {
    Log.i(LogUtils.generateTag(this), "Draw comic " + comic);
    title.setText(comic.getTitle());
    year.setText(comic.getYear());
    description.setText(comic.getDescription());
  }

  public void drawHeader(String image) {
    Picasso.with(getContext()).load(image).into(triangleImageView);
  }

  public void showNoComicSelected() {
    noCharacter.setVisibility(View.VISIBLE);
  }

  public void hideNoComicSelected() {
    noCharacter.setVisibility(View.INVISIBLE);
  }


}
