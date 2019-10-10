package com.hites.data.source

import com.hites.data.Movie
import com.hites.data.remote.MovieDbApiService
import com.hites.domain.Movie as DomainMovie

class RemoteDataSource (private val movieDbApiService: MovieDbApiService) :
    DataSource {
    override fun getMovieList(): List<DomainMovie> {
        val movieList = movieDbApiService.getMovieList()
        return convertToDomainMovie(movieList)
    }

    fun convertToDomainMovie(movieList: List<Movie>): List<DomainMovie> {
        return movieList.map { movie ->
            DomainMovie(
                movie.popularity,
                movie.vote_count,
                movie.video,
                movie.poster_path,
                movie.id,
                movie.adult,
                movie.backdrop_path,
                movie.original_language,
                movie.original_title,
                movie.genre_ids,
                movie.title,
                movie.vote_average,
                movie.overview,
                movie.release_date
            )
        }
    }

}