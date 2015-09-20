package com.github.glomadrian.wallapopcodetest.app.di.module;

import com.github.glomadrian.wallapopcodetest.app.executor.interactor.InteractorExecutor;
import com.github.glomadrian.wallapopcodetest.app.executor.main.MainThreadExecutor;
import com.github.glomadrian.wallapopcodetest.domain.interactor.comics.GetComicsInteractor;
import com.github.glomadrian.wallapopcodetest.domain.repository.ComicRepository;
import com.github.glomadrian.wallapopcodetest.ui.comics.presenter.ComicsPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Adrián García Lomas
 */
@Module
public class ComicsModule {

  @Provides
  public GetComicsInteractor provideGetComicsInteractor(MainThreadExecutor mainThreadExecutor,
      InteractorExecutor interactorExecutor, ComicRepository comicRepository) {
    return new GetComicsInteractor(mainThreadExecutor, interactorExecutor, comicRepository);
  }

  @Provides
  public ComicsPresenter provideComicsPresenter(GetComicsInteractor getComicsInteractor,
      ComicRepository comicRepository) {
    return new ComicsPresenter(getComicsInteractor, comicRepository);
  }
}
