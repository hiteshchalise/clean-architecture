package com.hites.data

import com.hites.data.remote.MovieDbApiService
import com.hites.data.source.RemoteDataSource
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.hites.domain.Movie as DomainMovie
import com.hites.data.Movie as DataMovie

class RemoteDataSourceTest {
    private val movieDbApiService: MovieDbApiService = mockk()
    private val remoteDataSource = RemoteDataSource(movieDbApiService)

    private val dataMovie = DataMovie(0.0, 0, false, "", 0, false, "", "", "", emptyList(), "", 0.0, "", "")
    private val domainMovie = DomainMovie(0.0, 0, false, "", 0, false, "", "", "", emptyList(), "", 0.0, "", "")

    @Test
    fun `Should Return EmptyList From Service`() {
        // Given
        every { runBlocking {movieDbApiService.getMovieList()}} returns emptyList()

        // When
        val movieList = runBlocking { remoteDataSource.getMovieList()}

        // Then
        assertEquals(movieList, emptyList<DataMovie>())
    }

    @Test
    fun `Should Return Proper List from Service`() {
        // Given
        val listOfMovie = listOf(dataMovie, dataMovie, dataMovie)
        every { runBlocking { movieDbApiService.getMovieList()} } returns listOfMovie

        // When
        val movieList = runBlocking {remoteDataSource.getMovieList()}

        // Then
        assertEquals(movieList.size, 3)
    }

    @Test
    fun `Should convert list of DataMovie to DomainMovie`() {
        // Given
        val listOfMovie = listOf(dataMovie, dataMovie, dataMovie)
        val listOfDomainMovie = listOf(domainMovie, domainMovie, domainMovie)

        // When
        val movieList = remoteDataSource.convertToDomainMovie(listOfMovie)

        // Then
        assertEquals(listOfDomainMovie, movieList)

    }
}