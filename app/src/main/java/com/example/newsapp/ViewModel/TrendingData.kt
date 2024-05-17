package com.example.newsapp.ViewModel

data class TrendingData(
    val id:Int,
    val news_cover:Int,
    val author_cover:Int,
    val news_title:String,
    val news_description:String,
    val news_author_name:String,
    val news_upload_time:String,
    val news_see_count:Int,
    val news_comment_count:Int
)
