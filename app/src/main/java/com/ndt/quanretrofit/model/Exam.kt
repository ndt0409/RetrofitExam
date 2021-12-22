package com.ndt.quanretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Exam(
    @Expose
    @SerializedName("status")
    var status: String,
    @Expose
    @SerializedName("totalResults")
    var totalResults: String,
    @Expose
    @SerializedName("articles")
    var articles: List<ArticlesModel>,

    )

data class ArticlesModel(
    @Expose
    @SerializedName("author")
    var author: String,
    @Expose
    @SerializedName("title")
    var title: String,
    @Expose
    @SerializedName("description")
    var description: String,
    @Expose
    @SerializedName("publishedAt")
    var publishedAt: String,
    @Expose
    @SerializedName("content")
    var content: String,
    @Expose
    @SerializedName("source")
    var source: SourceModel
)

data class SourceModel(
    @Expose
    @SerializedName("id")
    var id: String,
    @Expose
    @SerializedName("name")
    var name: String,

    )