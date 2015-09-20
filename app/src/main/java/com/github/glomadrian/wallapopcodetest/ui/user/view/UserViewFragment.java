package com.github.glomadrian.wallapopcodetest.ui.user.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.glomadrian.wallapopcodetest.R;

/**
 * @author Adrián García Lomas
 */
public class UserViewFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.user_view, container, false);
  }
}
