package com.hites.cleanarchitecture.framework

import com.hites.data.Movie
import com.hites.data.remote.MovieDbApiService
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi: MovieDbApiService {

    @GET("/3/discover/movie?api_key=7c67b6586378d5811be5e5fb14f222bf")
    override fun getMovieList(): List<Movie>
}