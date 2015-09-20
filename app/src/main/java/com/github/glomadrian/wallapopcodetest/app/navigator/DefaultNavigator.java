package com.github.glomadrian.wallapopcodetest.app.navigator;

import android.app.Activity;
import android.content.Intent;
import com.github.glomadrian.wallapopcodetest.ui.detail.view.DetailView;

/**
 * @author Adrián García Lomas
 */
public class DefaultNavigator implements Navigator {

  protected Activity activity;

  protected void launch(Intent intent) {
    activity.startActivity(intent);
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public Activity getActivity() {
    return activity;
  }

  public void finish() {
    activity.finish();
  }

  @Override public void goToDetailView() {
    Intent intent = new Intent(activity, DetailView.class);
    launch(intent);
  }
}
