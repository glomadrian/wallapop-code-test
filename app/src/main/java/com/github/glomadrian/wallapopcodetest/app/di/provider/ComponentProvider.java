package com.github.glomadrian.wallapopcodetest.app.di.provider;

import com.github.glomadrian.wallapopcodetest.app.di.component.application.ApplicationComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.comic.ComicComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.comic.DaggerComicComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.comicinfo.ComicInfoComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.comicinfo.DaggerComicInfoComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.detail.DaggerDetailViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.detail.DetailViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.main.DaggerMainViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.component.main.MainViewComponent;
import com.github.glomadrian.wallapopcodetest.app.di.module.ComicInfoModule;
import com.github.glomadrian.wallapopcodetest.app.di.module.ComicModule;
import com.github.glomadrian.wallapopcodetest.app.di.module.DetailViewModule;
import com.github.glomadrian.wallapopcodetest.app.di.module.MainViewModule;

/**
 * @author Adrián García Lomas
 */
public final class ComponentProvider {

  private static MainViewComponent mainViewComponent = null;
  private static ComicComponent comicComponent = null;
  private static DetailViewComponent detailViewComponent = null;
  private static ComicInfoComponent comicInfoComponent = null;

  private ComponentProvider() {
  }

  public static MainViewComponent getMainViewComponent(ApplicationComponent applicationComponent) {
    if (mainViewComponent == null) {
      mainViewComponent = DaggerMainViewComponent.builder()
          .applicationComponent(applicationComponent)
          .mainViewModule(new MainViewModule())
          .build();
    }
    return mainViewComponent;
  }

  public static ComicComponent getComicComponent(ApplicationComponent applicationComponent) {
    if (comicComponent == null) {
      comicComponent = DaggerComicComponent.builder()
          .applicationComponent(applicationComponent)
          .comicModule(new ComicModule())
          .build();
    }
    return comicComponent;
  }

  public static DetailViewComponent getDetailViewComponent(
      ApplicationComponent applicationComponent) {
    if (detailViewComponent == null) {
      detailViewComponent = DaggerDetailViewComponent.builder()
          .applicationComponent(applicationComponent)
          .detailViewModule(new DetailViewModule())
          .build();
    }
    return detailViewComponent;
  }

  public static ComicInfoComponent getComicInfoComponent(
      ApplicationComponent applicationComponent) {
    if (comicInfoComponent == null) {
      comicInfoComponent = DaggerComicInfoComponent.builder()
          .applicationComponent(applicationComponent)
          .comicInfoModule(new ComicInfoModule())
          .build();
    }
    return comicInfoComponent;
  }
}
