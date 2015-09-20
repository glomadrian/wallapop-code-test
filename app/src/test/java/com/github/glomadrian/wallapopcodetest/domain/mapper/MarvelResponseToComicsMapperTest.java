package com.github.glomadrian.wallapopcodetest.domain.mapper;

import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.ComicsResponse;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.Data;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.Image;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.Result;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.model.Thumbnail;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Adrián García Lomas
 */
public class MarvelResponseToComicsMapperTest {

  @Test
  public void mapToComicLisShouldReturnAComicList() {
    Thumbnail thumbnail = mock(Thumbnail.class);
    when(thumbnail.getPath()).thenReturn("http://fakeimage");
    when(thumbnail.getExtension()).thenReturn("jpg");

    List<Image> listMocked = mock(List.class);
    when(listMocked.size()).thenReturn(0);

    Result mockedResult = mock(Result.class);
    when(mockedResult.getTitle()).thenReturn("Comic");
    when(mockedResult.getThumbnail()).thenReturn(thumbnail);
    when(mockedResult.getDescription()).thenReturn("this is the description");
    when(mockedResult.getId()).thenReturn("1");
    when(mockedResult.getImages()).thenReturn(listMocked);

    List<Result> stubList = new ArrayList<>();
    stubList.add(mockedResult);

    Data mockedData = mock(Data.class);
    when(mockedData.getCount()).thenReturn("1");
    when(mockedData.getResults()).thenReturn(stubList);

    ComicsResponse mockedComicsResponse = mock(ComicsResponse.class);
    when(mockedComicsResponse.getData()).thenReturn(mockedData);

    MarvelResponseToComicsMapper marvelResponseToComicsMapper = new MarvelResponseToComicsMapper();
    List<Comic> comics = marvelResponseToComicsMapper.map(mockedComicsResponse);

    Assert.assertTrue(comics.size() > 0);
  }
}
