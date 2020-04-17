package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import io.micronaut.test.annotation.MicronautTest

import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieClientImplTest extends Specification {

    @Inject
    MovieClient movieClientMock = Mock()

    @Inject
    MovieRegistryImpl registry

    void "Injection should work"(){
        expect:
        movieClientMock != null
        registry != null
    }

    void "Getting a movie by it's imdb ID should work"(){
        when:
        movieClientMock.getMovieDetail("1234abcd")

        then:
        Movie movie = new Movie(imdbId: "1234abcd")
        registry.addMovieToFavorites(movie.imdbId)
        registry.listFavorites().size() == 1

    }

}
