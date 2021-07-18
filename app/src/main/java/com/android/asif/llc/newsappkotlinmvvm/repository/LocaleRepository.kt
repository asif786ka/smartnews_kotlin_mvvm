package com.android.asif.llc.newsappkotlinmvvm.repository

import com.android.asif.llc.newsappkotlinmvvm.db.ArticleDao
import com.android.asif.llc.newsappkotlinmvvm.model.Article

import javax.inject.Inject

class LocaleRepository @Inject constructor(
    val db: ArticleDao
) : BaseRepository() {

    suspend fun insertNewsToDb(article: Article) = db.insertArticle(article)

    suspend fun deleteNews(article: Article) = db.deleteArticle(article)

    fun getSavedNews() = db.getSavedArticles()
}