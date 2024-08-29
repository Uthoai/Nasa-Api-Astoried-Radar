package com.mehedi.nasaapiastoroiedradar.worker

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mehedi.nasaapiastoroiedradar.views.home.HomeViewModel
import retrofit2.HttpException


class RefreshDataWorker(applicationContext: Context, params: WorkerParameters)
    : CoroutineWorker(applicationContext, params) {

    private val viewModel = HomeViewModel(applicationContext as Application)

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        return try {
            viewModel.getImageOfTheDay()
            viewModel.getAsteroidData()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

}