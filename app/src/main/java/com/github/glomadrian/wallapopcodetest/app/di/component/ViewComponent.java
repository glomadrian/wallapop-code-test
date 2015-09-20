package com.github.glomadrian.wallapopcodetest.app.di.component;

import com.github.glomadrian.wallapopcodetest.ui.View;

/**
 * @author Adrián García Lomas
 */
public interface ViewComponent<T extends View> {

  void inject(T view);
}
