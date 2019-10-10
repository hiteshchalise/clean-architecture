package com.hites.usecase

import com.hites.domain.Movie

interface MovieUseCase{
    fun execute(): List<Movie>
}