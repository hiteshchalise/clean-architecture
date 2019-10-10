package com.hites.cleanarchitecture.presentation

import com.hites.cleanarchitecture.Movie

interface MainPresenter {
    fun getMovieList(): List<Movie>
}