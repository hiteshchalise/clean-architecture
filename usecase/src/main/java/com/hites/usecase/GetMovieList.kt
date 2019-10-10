package com.hites.usecase

import com.hites.data.repository.IRepository
import com.hites.domain.Movie

class GetMovieList(private val repository: IRepository): MovieUseCase{
    override suspend fun execute(): List<Movie> {
        return repository.getMovieList()
    }
}