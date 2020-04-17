package gl51.movie.service.impl

import gl51.movie.service.MovieClient
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieRegistryImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    void "injectionshouldwork"() {
        expect:
        registry != null
    }

    void "favoritesshouldbeempty"() {
        expect:
        registry.listFavorites() == []
    }

    void "addingafacoviteshouldfillinthedatabase"() {
        when:
        registry.addMovieToFavorites("aaaa");
        then:
        registry.listFavorites().size() == 1
    }

    @MockBean(MovieClientImpl)
    MovieClient client() {
        Mock(MovieClient)
    }
}
