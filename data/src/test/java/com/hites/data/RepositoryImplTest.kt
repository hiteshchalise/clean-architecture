package com.hites.data

import com.hites.data.repository.RepositoryImpl
import com.hites.data.source.DataSource
import com.hites.domain.Movie
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RepositoryImplTest{
    private val dataSource: DataSource = mockk()
    private val repository = RepositoryImpl(dataSource)
    private val mockMovie: Movie = mockk()
    @Test
    fun `Should Get Empty List From Remote` (){
        // Given
        every { dataSource.getMovieList() } returns emptyList()
        // When
        val movieList = repository.getMovieList()
        // Then
        assertEquals(movieList, emptyList<Movie>())
    }

    @Test
    fun `Should Get Proper List From Remote` (){
        // Given
        every { dataSource.getMovieList() } returns listOf(mockMovie, mockMovie, mockMovie)
        // When
        val movieList = repository.getMovieList()
        // Then
        assertEquals(movieList.size, 3)
    }
}