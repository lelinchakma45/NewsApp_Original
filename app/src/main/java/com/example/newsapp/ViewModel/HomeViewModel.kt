package com.example.newsapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.Model.NewsProperty

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    // LiveData properties for each category
    val listNewsTechnology: LiveData<List<NewsProperty>> = MutableLiveData()
    val listEntertain: LiveData<List<NewsProperty>> = MutableLiveData()
    val listBusiness: LiveData<List<NewsProperty>> = MutableLiveData()
    val listHealth: LiveData<List<NewsProperty>> = MutableLiveData()
    val listSport: LiveData<List<NewsProperty>> = MutableLiveData()
    val listScience: LiveData<List<NewsProperty>> = MutableLiveData()

    val navigateToDetailNews = MutableLiveData<NewsProperty?>()

    fun onItemSelected(news: NewsProperty) {
        navigateToDetailNews.value = news
    }

    fun onFinishItemSelected() {
        navigateToDetailNews.value = null
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HomeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
