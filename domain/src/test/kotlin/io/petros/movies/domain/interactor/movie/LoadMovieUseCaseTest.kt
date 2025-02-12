package io.petros.movies.domain.interactor.movie

import io.mockk.coEvery
import io.mockk.mockk
import io.petros.movies.domain.model.Result
import io.petros.movies.domain.model.movie.Movie
import io.petros.movies.domain.repository.movie.MoviesRepository
import io.petros.movies.test.domain.movie
import io.petros.movies.test.utils.MainCoroutineScopeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import strikt.api.expect
import strikt.assertions.isEqualTo

@ExperimentalCoroutinesApi
class LoadMovieUseCaseTest {

    companion object {

        private const val MOVIE_ID = 419_704

    }

    @get:Rule val coroutineScope = MainCoroutineScopeRule()

    private val params = LoadMovieUseCase.Params(MOVIE_ID)

    private val movie = Result.Success(movie())
    private val movieStream = flow<Result<Movie>> { movie }

    private val moviesRepositoryMock = mockk<MoviesRepository>()
    private val testedClass = LoadMovieUseCase(moviesRepositoryMock)

    @Test
    fun `when executing the use case, then the movie stream is the expected one`() = coroutineScope.runBlockingTest {
        coEvery { moviesRepositoryMock.loadMovieStream(MOVIE_ID) } returns movieStream

        val result = testedClass(params)

        result.collectLatest { expect { that(it).isEqualTo(movie) } }
    }

}
