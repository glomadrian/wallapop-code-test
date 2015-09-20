package com.github.glomadrian.wallapopcodetest.app.navigator;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import com.github.glomadrian.wallapopcodetest.ui.detail.view.DetailView;
import com.github.glomadrian.wallapopcodetest.ui.main.view.MainActivity;

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

  @Override
  public void goToDetailView(int comicId) {
    int currentOrientation = getActivity().getResources().getConfiguration().orientation;

    if (activity instanceof MainActivity
        && currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
      ((MainActivity) activity).showComicInfoView(comicId);
    } else {
      Intent intent = new Intent(activity, DetailView.class);
      intent.putExtra(DetailView.COMIC_ID, comicId);
      launch(intent);
    }
  }

  public Activity getActivity() {
    return activity;
  }

  public void finish() {
    activity.finish();
  }
}
