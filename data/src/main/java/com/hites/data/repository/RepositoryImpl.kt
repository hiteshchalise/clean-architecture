package com.hites.data.repository

import com.hites.data.source.DataSource
import com.hites.domain.Movie

class RepositoryImpl(private val dataSource: DataSource) :
    IRepository {
    override fun getMovieList(): List<Movie> {
        return dataSource.getMovieList()
    }
}