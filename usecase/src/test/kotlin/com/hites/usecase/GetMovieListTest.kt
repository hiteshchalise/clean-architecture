package com.hites.usecase

import com.hites.data.repository.IRepository
import com.hites.domain.Movie
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GetMovieListTest {
    private var mockRepository: IRepository = mockk()
    private var mockMovie: Movie = mockk()
    private val getMovieList = GetMovieList(mockRepository)

    @Test
    fun `Should Get Empty Movie List From Repository`() {
        // Given
        every { mockRepository.getMovieList() } returns emptyList()
        // When
        val movieDetailList: List<Movie> = getMovieList.execute()
        // Then
        assertEquals(movieDetailList, emptyList<Movie>())
    }

    @Test
    fun `Should Get Proper MovieList from Repository`(){
        // Given
        every { mockRepository.getMovieList() } returns listOf(
            mockMovie,
            mockMovie,
            mockMovie)
        // When
        val movieDetails:List<Movie> = getMovieList.execute()
        // Then
        assertEquals(movieDetails.size, 3)
    }
}