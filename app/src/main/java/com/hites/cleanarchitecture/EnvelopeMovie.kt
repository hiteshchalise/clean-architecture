package com.hites.cleanarchitecture


data class EnvelopeMovie<T>(

    val page : Int,
    val total_results : Int,
    val total_pages : Int,
    val results : List<T>
)