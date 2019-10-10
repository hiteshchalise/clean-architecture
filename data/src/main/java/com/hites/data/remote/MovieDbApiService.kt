package com.hites.data.remote

import com.hites.data.Movie
import retrofit2.http.GET

interface MovieDbApiService{
    @GET("/3/discover/movie?api_key=7c67b6586378d5811be5e5fb14f222bf")
    fun getMovieList(): List<Movie>
}