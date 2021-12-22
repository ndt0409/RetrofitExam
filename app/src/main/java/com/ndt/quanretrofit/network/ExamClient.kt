package com.ndt.quanretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ExamClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    operator fun invoke(): ExamService {
        return retrofit.create(ExamService::class.java)
    }
}