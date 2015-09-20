package com.github.glomadrian.wallapopcodetest.ui.detail.view;

import com.github.glomadrian.wallapopcodetest.R;
import com.github.glomadrian.wallapopcodetest.app.AbstractActivity;
import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.provider.ComponentProvider;
import com.github.glomadrian.wallapopcodetest.ui.LifeCyclePresenter;
import com.github.glomadrian.wallapopcodetest.ui.comicinfo.view.ComicInfoFragment;
import com.github.glomadrian.wallapopcodetest.ui.detail.presenter.DetailPresenter;
import javax.inject.Inject;

/**
 * @author Adrián García Lomas
 */
public class DetailView extends AbstractActivity {

  public static final String COMIC_ID = "comicId";
  @Inject protected DetailPresenter detailPresenter;

  @Override
  public void onViewReady() {
    super.onViewReady();
    int comidId = getIntent().getExtras().getInt(COMIC_ID);
    detailPresenter.onComicIdAvailable(comidId);
  }

  @Override
  public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getApplication()).getApplicationComponent();
    return ComponentProvider.getDetailViewComponent(applicationComponent);
  }

  @Override
  public LifeCyclePresenter bindPresenter() {
    return detailPresenter;
  }

  @Override
  public int bindLayout() {
    return R.layout.detail_view;
  }

  public void showComicInfoView(int comicId) {
    ComicInfoFragment comicInfoFragment = ComicInfoFragment.newInstance(comicId);
    getSupportFragmentManager().beginTransaction()
        .add(R.id.comic_info_frame, comicInfoFragment)
        .commit();
  }
}
