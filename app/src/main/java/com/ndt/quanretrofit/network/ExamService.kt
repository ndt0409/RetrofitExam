package com.ndt.quanretrofit.network

import com.ndt.quanretrofit.model.Exam
import retrofit2.Call
import retrofit2.http.GET

interface ExamService {

    @GET("top-headlines?sources=techcrunch&apiKey=9f98a7987c4546d0a3861037d7fbaf01")
    fun getAllExam() : Call<Exam>
}