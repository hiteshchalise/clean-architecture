package com.hites.usecase

import com.hites.domain.Movie

interface MovieUseCase{
    suspend fun execute(): List<Movie>
}