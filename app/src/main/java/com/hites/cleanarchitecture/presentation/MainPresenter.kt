package com.hites.cleanarchitecture.presentation

import com.hites.cleanarchitecture.Movie

interface MainPresenter {
    suspend fun getMovieList(): List<Movie>
}