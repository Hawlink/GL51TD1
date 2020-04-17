package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import spock.lang.Specification

import javax.inject.Inject

/**Creation of a mock test for the movie client **/
@MicronautTest
class MovieClientImplTest extends Specification {

    @Inject
    MovieClient client

    void "injection should work"() {
        expect:
        client != null
    }

    void "mocking the call to movie details should work"() {
        when:
        client.getMovieDetail("aaaa")
        then:
        Movie movie = new Movie(imdbID: "aaaa")
    }

    @MockBean(MovieClientImpl)
    MovieClient client() {
        Mock(MovieClient)
    }

}
