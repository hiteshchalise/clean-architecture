package com.hites.data.source

import com.hites.domain.Movie

interface DataSource{
    suspend fun getMovieList(): List<Movie>
}