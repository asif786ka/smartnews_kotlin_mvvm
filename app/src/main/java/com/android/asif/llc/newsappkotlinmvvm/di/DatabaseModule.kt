package com.android.asif.llc.newsappkotlinmvvm.di

import android.content.Context
import androidx.room.Room
import com.android.asif.llc.newsappkotlinmvvm.db.ArticleDatabase
import com.android.asif.llc.newsappkotlinmvvm.util.Constant.Companion.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideArticleDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        ArticleDatabase::class.java,
        NEWS_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideArticleDao(db: ArticleDatabase) = db.getArticleDao()
}