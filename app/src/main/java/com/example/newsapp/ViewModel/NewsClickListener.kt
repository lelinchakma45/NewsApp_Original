package com.example.newsapp.ViewModel

import com.example.newsapp.Model.NewsProperty

class NewsClickListener(val clickListener: (news: NewsProperty) -> Unit) {
    fun onClick(news: NewsProperty) = clickListener(news)
}
