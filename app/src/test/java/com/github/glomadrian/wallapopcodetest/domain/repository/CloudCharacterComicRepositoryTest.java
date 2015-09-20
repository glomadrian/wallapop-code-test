package com.github.glomadrian.wallapopcodetest.domain.repository;

import com.github.glomadrian.wallapopcodetest.data.comic.ComicDataSource;
import com.github.glomadrian.wallapopcodetest.data.comic.exception.ComicsNotFoundException;
import com.github.glomadrian.wallapopcodetest.domain.model.Character;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Adrián García Lomas
 */
public class CloudCharacterComicRepositoryTest {

  @Test
  public void addComicToRepository() {

    ComicDataSource comicDataSource = mock(ComicDataSource.class);
    Comic mockedComic = mock(Comic.class);
    when(mockedComic.getId()).thenReturn(1);

    CloudCharacterComicRepository cloudCharacterComicRepository =
        new CloudCharacterComicRepository(comicDataSource);

    cloudCharacterComicRepository.add(mockedComic);

    Assert.assertFalse(cloudCharacterComicRepository.isEmpty());
  }

  @Test
  public void deleteComicFromRepository() {

    ComicDataSource comicDataSource = mock(ComicDataSource.class);
    Comic mockedComic = mock(Comic.class);
    when(mockedComic.getId()).thenReturn(1);

    CloudCharacterComicRepository cloudCharacterComicRepository =
        new CloudCharacterComicRepository(comicDataSource);

    cloudCharacterComicRepository.add(mockedComic);
    cloudCharacterComicRepository.erase();

    Assert.assertTrue(cloudCharacterComicRepository.isEmpty());
  }

  @Test
  public void findByIdShouldReturnComic() {

    ComicDataSource comicDataSource = mock(ComicDataSource.class);
    Comic mockedComic = mock(Comic.class);
    when(mockedComic.getId()).thenReturn(1);

    CloudCharacterComicRepository cloudCharacterComicRepository =
        new CloudCharacterComicRepository(comicDataSource);

    cloudCharacterComicRepository.add(mockedComic);

    Assert.assertNotNull(cloudCharacterComicRepository.findById(1));
  }

  @Test
  public void fetchWithoutAmountShouldReturnAList() throws ComicsNotFoundException {

    ComicDataSource comicDataSource = mock(ComicDataSource.class);

    List<Comic> mockedList = (List<Comic>) mock(List.class);
    when(mockedList.size()).thenReturn(10);
    when(comicDataSource.getComics(anyInt(), anyInt())).thenReturn(mockedList);

    com.github.glomadrian.wallapopcodetest.domain.model.Character mockCharacter =
        mock(Character.class);
    when(mockCharacter.getId()).thenReturn(1);

    CloudCharacterComicRepository cloudCharacterComicRepository =
        new CloudCharacterComicRepository(comicDataSource);
    cloudCharacterComicRepository.initialize(mockCharacter);

    List<Comic> comics = cloudCharacterComicRepository.fetch();

    Assert.assertNotNull(comics);
  }
}
