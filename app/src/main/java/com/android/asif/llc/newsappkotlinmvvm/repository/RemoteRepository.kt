package com.android.asif.llc.newsappkotlinmvvm.repository

import com.android.asif.llc.newsappkotlinmvvm.model.Article
import com.android.asif.llc.newsappkotlinmvvm.network.NewsApi
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val newsApi: NewsApi
) : BaseRepository() {

    suspend fun getBreakingNews(): MutableList<Article>? {
        return safeApiCall(
            call = { newsApi.getBreakingNews() },
            error = "Error fetching news"
        )?.articles?.toMutableList()
    }

    suspend fun searchNews(searchQuery: String): MutableList<Article>? {
        return safeApiCall(
            call = { newsApi.searchForNews(searchQuery) },
            error = "Error fetching news"
        )?.articles?.toMutableList()
    }
}