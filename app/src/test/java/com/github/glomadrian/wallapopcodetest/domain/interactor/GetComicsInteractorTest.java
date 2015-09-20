package com.github.glomadrian.wallapopcodetest.domain.interactor;

import android.content.res.Resources;
import com.github.glomadrian.wallapopcodetest.app.executor.interactor.NoThreadInteractorExecutor;
import com.github.glomadrian.wallapopcodetest.app.executor.main.MainThreadExecutor;
import com.github.glomadrian.wallapopcodetest.domain.interactor.comics.GetComicsInteractor;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.domain.repository.ComicRepository;
import java.util.List;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Adrián García Lomas
 */
public class GetComicsInteractorTest {

  @Test
  public void getComicInteractorShouldCallTheCallbackOnSuccess() {

    List<Comic> mockedList = (List<Comic>) mock(List.class);

    ComicRepository mockedComicRepository = mock(ComicRepository.class);
    when(mockedComicRepository.fetch(anyInt())).thenReturn(mockedList);

    GetComicsInteractor.ComicsInteractorCallback mockedCallback =
        mock(GetComicsInteractor.ComicsInteractorCallback.class);

    GetComicsInteractor getComicsInteractor =
        new GetComicsInteractor(new StubMainThreadExecutor(), new NoThreadInteractorExecutor(),
            mockedComicRepository);
    getComicsInteractor.execute(mockedCallback);

    verify(mockedCallback).onComicsFetch(anyList());
  }

  @Test
  public void getComicInteractorShouldCallCallbackErrorIfFails() {

    ComicRepository mockedComicRepository = mock(ComicRepository.class);
    when(mockedComicRepository.fetch()).thenThrow(new Resources.NotFoundException());

    GetComicsInteractor.ComicsInteractorCallback mockedCallback =
        mock(GetComicsInteractor.ComicsInteractorCallback.class);

    GetComicsInteractor getComicsInteractor =
        new GetComicsInteractor(new StubMainThreadExecutor(), new NoThreadInteractorExecutor(),
            mockedComicRepository);
    getComicsInteractor.execute(mockedCallback);

    verify(mockedCallback).onFetchError();
  }

  private class StubMainThreadExecutor implements MainThreadExecutor<Runnable> {

    @Override
    public void execute(Runnable runnable) {
      runnable.run();
    }
  }
}
