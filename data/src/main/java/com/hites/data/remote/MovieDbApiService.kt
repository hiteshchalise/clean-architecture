package com.hites.data.remote

import com.hites.data.Movie

interface MovieDbApiService{
    fun getMovieList(): List<Movie>
}