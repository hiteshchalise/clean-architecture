package com.hites.cleanarchitecture.presentation

import com.hites.cleanarchitecture.Movie as PresentationMovie
import com.hites.cleanarchitecture.framework.MovieApi
import com.hites.data.Movie as DataMovie

class MovieUseCaseImpl(private val movieApi: MovieApi) : MovieUseCase{

    override fun execute(): List<PresentationMovie> {
        val movieList = movieApi.getMovieList()
        return convertFromDataMovie(movieList)
    }

    fun convertFromDataMovie(movieList: List<DataMovie>): List<PresentationMovie> {
        return movieList.map { movie ->
            PresentationMovie(
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