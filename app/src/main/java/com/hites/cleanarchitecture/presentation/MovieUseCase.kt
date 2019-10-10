package com.hites.cleanarchitecture.presentation

import com.hites.cleanarchitecture.Movie

interface MovieUseCase {
    fun execute(): List<Movie>
}
