package com.hites.cleanarchitecture.presentation

import com.hites.cleanarchitecture.Movie
import com.hites.cleanarchitecture.framework.MovieApi
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import com.hites.data.Movie as DataMovie

internal class MovieUseCaseImplTest {
    private val movieApi: MovieApi = mockk()
    private val movieUseCaseImpl = MovieUseCaseImpl(movieApi)

    private val presentationMovie =
        Movie(0.0, 0, false, "", 0, false, "", "", "", emptyList(), "", 0.0, "", "")
    private val dataMovie =
        DataMovie(0.0, 0, false, "", 0, false, "", "", "", emptyList(), "", 0.0, "", "")

    @Test
    fun `Should Return Empty Movie List`() {
        // Given
        every { runBlocking { movieApi.getMovieList() } } returns emptyList()
        // When
        val movieList = runBlocking { movieUseCaseImpl.execute() }
        // Then
        assertEquals(movieList, emptyList<Movie>())
    }

    @Test
    fun `Should Return Proper Movie List`() {
        // Given
        every { runBlocking { movieApi.getMovieList() } } returns listOf(
            dataMovie,
            dataMovie,
            dataMovie
        )
        // When
        val movieList = runBlocking { movieUseCaseImpl.execute() }
        // Then
        assertEquals(movieList.size, 3)
    }

    @Test
    fun `Should Convert DataMovie to PresentationMovie`() {
        // Given
        val dataMovieList = listOf(dataMovie, dataMovie, dataMovie)
        val expectedMovieList = listOf(presentationMovie, presentationMovie, presentationMovie)

        // When
        val actualMovieList = movieUseCaseImpl.convertFromDataMovie(dataMovieList)

        // Then
        assertEquals(expectedMovieList, actualMovieList)
    }
}