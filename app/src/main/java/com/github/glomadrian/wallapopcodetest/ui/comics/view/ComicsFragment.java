package com.github.glomadrian.wallapopcodetest.ui.comics.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.github.glomadrian.wallapopcodetest.R;
import com.github.glomadrian.wallapopcodetest.app.AbstractFragment;
import com.github.glomadrian.wallapopcodetest.app.MainApplication;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.comics.DaggerComicsComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.ComicsModule;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.ui.LifeCyclePresenter;
import com.github.glomadrian.wallapopcodetest.ui.comics.presenter.ComicsPresenter;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Adrián García Lomas
 */
public class ComicsFragment extends AbstractFragment {

  @Inject protected ComicsPresenter comicsPresenter;
  //@Bind(R.id.comics_list) protected RecyclerView comicsListView;

  @Override
  public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getActivity().getApplication()).getApplicationComponent();
    return DaggerComicsComponent.builder()
        .applicationComponent(applicationComponent)
        .comicsModule(new ComicsModule())
        .build();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    comicsPresenter.onViewReady();
  }

  @Override
  public LifeCyclePresenter bindPresenter() {
    return comicsPresenter;
  }

  @Override
  public int bindLayout() {
    return R.layout.comics_view;
  }

  public void showComics(List<Comic> comicList) {
    //Add comics to the adapter
  }

  public void showLoading() {
    //TODO
  }

  public void hideLoading() {
    //TODO
  }

  public void showError(String error) {
    //TODO
  }

  public static ComicsFragment newInstance() {
    return new ComicsFragment();
  }
}
