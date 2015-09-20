package com.github.glomadrian.wallapopcodetest.app.di.module;

import com.github.glomadrian.wallapopcodetest.data.comic.ComicDataSource;
import com.github.glomadrian.wallapopcodetest.domain.model.Character;
import com.github.glomadrian.wallapopcodetest.domain.repository.CloudCharacterComicRepository;
import com.github.glomadrian.wallapopcodetest.domain.repository.ComicRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author Adrián García Lomas
 */
@Module
public class RepositoryModule {

  @Provides
  @Singleton
  public ComicRepository provideComicRepository(ComicDataSource comicDataSource) {
    CloudCharacterComicRepository comicRepository =
        new CloudCharacterComicRepository(comicDataSource);
    com.github.glomadrian.wallapopcodetest.domain.model.Character captainAmerica = new Character();
    captainAmerica.setId(1009220);
    comicRepository.initialize(captainAmerica);
    return comicRepository;
  }
}
