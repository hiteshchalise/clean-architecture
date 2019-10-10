package com.hites.data.repository

import com.hites.domain.Movie

interface IRepository{
    suspend fun getMovieList(): List<Movie>
}