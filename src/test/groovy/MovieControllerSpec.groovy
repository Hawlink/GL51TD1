package gl51

import gl51.movie.data.Movie
import gl51.movie.data.MovieRequest
import gl51.movie.service.MovieClient
import gl51.movie.service.impl.MovieRegistryImpl
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.reactivex.Flowable
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Shared
import io.micronaut.test.annotation.MockBean
import io.micronaut.http.HttpRequest
import io.micronaut.core.type.Argument

import javax.inject.Inject

@MicronautTest
class MovieControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    RxHttpClient client

    @Inject
    MovieRegistryImpl registry

    void "testindex"() {
        given:
        Flowable flowable = client.retrieve(HttpRequest.GET("/movie"), Argument.listOf(Movie))
        def content = flowable.firstElement().blockingGet()
        expect:
        content == []
    }

    void "testfilmcreation"() {
        given:
        HttpResponse response = client.toBlocking().exchange(
                HttpRequest.POST("/movie", new MovieRequest(imdbId: "aaaaa"))
        )
        Flowable flowable = client.retrieve(HttpRequest.GET("/movie"), Argument.listOf(Movie))
        def content = flowable.firstElement().blockingGet()
        expect:
        response.status == HttpStatus.CREATED
        //content.find(it.title == 'my movie' && it.imdbId == "aaaaa")
    }

    @MockBean()
    MovieClient movieClient() {
        def mock = Mock(MovieClient)
        mock.getMovieDetail("aaaaa") >> new Movie(imdbID: "aaaaa", title: 'my movie')
        mock
    }

}
