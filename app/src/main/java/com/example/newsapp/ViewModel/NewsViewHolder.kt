package com.example.newsapp.ViewModel

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.Model.NewsProperty

class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.item_news
    }

    fun bind(news: NewsProperty, clickListener: NewsClickListener) {
        binding.news = news
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }
}
