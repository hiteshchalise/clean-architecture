package com.hites.cleanarchitecture.presentation

import com.hites.usecase.MovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.hites.cleanarchitecture.Movie as PresentationMovie
import com.hites.domain.Movie as DomainMovie

class MainPresenterImpl(
    private val view: MainView,
    private val movieUseCase: MovieUseCase
) : MainPresenter {

    override suspend fun getMovieList(): List<PresentationMovie> {
        return withContext(Dispatchers.IO) {
            val listDomainMovie = movieUseCase.execute()
            convertFromDomainMovie(listDomainMovie)
        }
    }


    private fun convertFromDomainMovie(movieList: List<DomainMovie>): List<PresentationMovie> {
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
