package com.hites.cleanarchitecture.presentation

import com.hites.cleanarchitecture.Movie

class MainPresenterImpl(
    private val view: MainView,
    private val movieList: MovieUseCase
) : MainPresenter{

    override fun getMovieList(): List<Movie> {
        return movieList.execute()
    }

}
