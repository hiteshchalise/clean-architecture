package com.hites.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hites.cleanarchitecture.R
import com.hites.cleanarchitecture.framework.MovieApi
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val retrofit = Retrofit
//            .Builder()
//            .baseUrl("https://api.themoviedb.org")
//            .build()
//        val movieApi: MovieApi = retrofit.create(MovieApi.class)
//        val movieUseCase = MovieUseCaseImpl()
//        val mainPresenter = MainPresenterImpl(this, movieUseCase)
    }
}
