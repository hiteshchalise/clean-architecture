package com.hites.data.source

import com.hites.domain.Movie

interface DataSource{
    fun getMovieList(): List<Movie>
}