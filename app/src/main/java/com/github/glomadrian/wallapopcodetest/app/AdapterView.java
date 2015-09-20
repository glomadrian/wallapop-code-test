package com.github.glomadrian.wallapopcodetest.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.github.glomadrian.wallapopcodetest.app.di.component.ViewComponent;
import com.github.glomadrian.wallapopcodetest.ui.Presenter;
import com.github.glomadrian.wallapopcodetest.ui.View;
import com.github.glomadrian.wallapopcodetest.utils.AssertUtils;

/**
 * @author Adrián García Lomas
 */
public abstract class AdapterView implements View {

  protected Context context;
  protected android.view.View view;
  protected ViewGroup viewGroup;
  private ViewComponent viewComponent;
  private int layout;
  private Presenter presenter;

  public AdapterView(Context context, ViewGroup viewGroup) {
    this.context = context;
    this.viewGroup = viewGroup;
    viewComponent = bindViewComponent(context.getApplicationContext());
    assertBindViewComponent();
    viewComponent.inject(this);
    presenter = bindPresenter();
    assertBindPresenter();
    initView();
    ButterKnife.bind(this, view);
    presenter.attachView(this);
    presenter.onViewReady();
    onAfterCreate();
  }

  private void initView() {
    layout = bindLayout();
    assertBindLayout();
    this.view = LayoutInflater.from(context).inflate(layout, viewGroup, false);
  }

  public void onAfterCreate() {
    //Empty
  }

  public abstract ViewComponent bindViewComponent(Context context);

  public abstract Presenter bindPresenter();

  public abstract int bindLayout();

  private void assertBindViewComponent() {
    AssertUtils.assertThis(viewComponent != null,
        "no viewComponent bind, bind a viewComponent to perform injection", getClass());
  }

  private void assertBindPresenter() {
    AssertUtils.assertThis(presenter != null,
        "no presenter bind, bind a presenter on bindPresenter() method", getClass());
  }

  private void assertBindLayout() {
    AssertUtils.assertThis(layout != 0, "No layout bind, bind a layout on bindLayout() method",
        getClass());
  }

  public android.view.View getView() {
    return view;
  }
}
