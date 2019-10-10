package com.hites.data.repository

import com.hites.domain.Movie

interface IRepository{
    fun getMovieList(): List<Movie>
}