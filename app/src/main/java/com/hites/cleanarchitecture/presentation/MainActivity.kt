package com.hites.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hites.cleanarchitecture.R
import com.hites.data.remote.MovieDbApiService
import com.hites.data.repository.RepositoryImpl
import com.hites.data.source.RemoteDataSource
import com.hites.usecase.GetMovieList
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), MainView, CoroutineScope {
    private val TAG = "CleanArchitectureApp"
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        job = Job()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(EnvelopingConverter())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val movieDbApiService = retrofit.create(MovieDbApiService::class.java)
        val datasource = RemoteDataSource(movieDbApiService)
        val repositoryImpl = RepositoryImpl(datasource)
        val movieUseCase = GetMovieList(repositoryImpl)
        val mainPresenter = MainPresenterImpl(this, movieUseCase)

        launch(coroutineContext){
            val movieList = mainPresenter.getMovieList()
            for (movie in movieList){
                Log.d(TAG, "OnCreate: $movie")
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
