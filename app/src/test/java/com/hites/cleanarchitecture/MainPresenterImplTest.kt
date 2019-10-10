package com.hites.cleanarchitecture

import com.hites.cleanarchitecture.presentation.MainPresenterImpl
import com.hites.cleanarchitecture.presentation.MainView
import com.hites.cleanarchitecture.presentation.MovieUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainPresenterImplTest {
    private val view: MainView = mockk()
    private val getMovieList: MovieUseCase = mockk()


    private val presentationMovie =
        Movie(0.0, 0, false, "", 0, false, "", "", "", emptyList(), "", 0.0, "", "")

    @Test
    fun `Should Return Empty MovieList`() {
        // Given
        val presenter = MainPresenterImpl(view, getMovieList)
        every { runBlocking { getMovieList.execute() } } returns emptyList()
        // When
        val movieList = runBlocking { presenter.getMovieList() }
        // Then
        assertEquals(movieList, emptyList<Movie>())
    }

    @Test
    fun `Should Return Proper MovieList`() {
        // Given
        val presenter = MainPresenterImpl(view, getMovieList)
        every { runBlocking { getMovieList.execute() } } returns listOf(
            presentationMovie,
            presentationMovie,
            presentationMovie
        )
        // When
        val movieList = runBlocking { presenter.getMovieList() }
        // Then
        assertEquals(movieList.size, 3)
    }


}