package com.android.asif.llc.newsappkotlinmvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.asif.llc.newsappkotlinmvvm.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getSavedArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}