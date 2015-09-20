package com.github.glomadrian.wallapopcodetest;

import com.github.glomadrian.wallapopcodetest.data.comic.exception.ComicsNotFoundException;
import com.github.glomadrian.wallapopcodetest.data.comic.marvel.MarvelServiceDataSource;
import com.github.glomadrian.wallapopcodetest.domain.model.Character;
import com.github.glomadrian.wallapopcodetest.domain.model.Comic;
import com.github.glomadrian.wallapopcodetest.domain.repository.CloudCharacterComicRepository;
import java.util.List;
import org.junit.Test;

/**
 * @author Adrián García Lomas
 */
public class RetrofitServiceTest {

  @Test
  public void test() throws ComicsNotFoundException {
    MarvelServiceDataSource marvelServiceDataSource =
        new MarvelServiceDataSource("http://gateway.marvel.com", "3a39768d38da927248f7ed89477e9ff6",
            "b80e34966642c6bf0d1b47b389462ee0a6b2d822");
    List<Comic> comicList = marvelServiceDataSource.getComics(10, 19, 1009664);
    comicList.size();
  }

  @Test
  public void testRepository() {
    MarvelServiceDataSource marvelServiceDataSource =
        new MarvelServiceDataSource("http://gateway.marvel.com", "3a39768d38da927248f7ed89477e9ff6",
            "b80e34966642c6bf0d1b47b389462ee0a6b2d822");
    CloudCharacterComicRepository cloudComicRepository =
        new CloudCharacterComicRepository(marvelServiceDataSource);
    Character character = new Character();
    character.setId(1009664);
    cloudComicRepository.initialize(character);
    List<Comic> comics10 = cloudComicRepository.fetch();
    List<Comic> comics20 = cloudComicRepository.fetch(3);
    comics20.size();
  }
}
