package com.android.asif.llc.newsappkotlinmvvm.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.asif.llc.newsappkotlinmvvm.model.Article
import com.android.asif.llc.newsappkotlinmvvm.repository.LocaleRepository
import com.android.asif.llc.newsappkotlinmvvm.repository.RemoteRepository
import kotlinx.coroutines.launch

class NewsViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository,
    private val localeRepository: LocaleRepository
) : ViewModel() {

    val newsLiveData = MutableLiveData<MutableList<Article>>()
    val searchNewsLiveData = MutableLiveData<MutableList<Article>>()

    init {
        getBreakingNews()
    }

    fun getBreakingNews() = viewModelScope.launch {
        val breakingNews = remoteRepository.getBreakingNews()
        newsLiveData.postValue(breakingNews)
    }

    fun searchNews(searchQuery: String) = viewModelScope.launch {
        val searchNews = remoteRepository.searchNews(searchQuery)
        searchNewsLiveData.postValue(searchNews)
    }

    fun saveNews(article: Article) = viewModelScope.launch {
        localeRepository.insertNewsToDb(article)
    }

    fun deleteNews(article: Article) = viewModelScope.launch {
        localeRepository.deleteNews(article)
    }

    fun getSavedNews() = localeRepository.getSavedNews()
}