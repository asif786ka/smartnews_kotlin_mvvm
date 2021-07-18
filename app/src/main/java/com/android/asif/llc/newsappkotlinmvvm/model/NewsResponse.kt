package com.android.asif.llc.newsappkotlinmvvm.model

import com.android.asif.llc.newsappkotlinmvvm.model.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)