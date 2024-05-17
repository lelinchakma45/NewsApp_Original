package com.example.newsapp.Adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.Model.NewsProperty
import com.example.newsapp.R
import com.example.newsapp.ViewModel.NewsClickListener
import com.example.newsapp.databinding.ItemNewsBinding
class NewsAdapter(private val clickListener: NewsClickListener) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var news: List<NewsProperty> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val withDataBinding: ItemNewsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_news, // Ensure this is the correct layout file name
            parent,
            false
        )
        return NewsViewHolder(withDataBinding)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = news[position]
        holder.bind(newsItem, clickListener)
    }

    class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: NewsProperty, clickListener: NewsClickListener) {
            binding.news = newsItem
            binding.clickListener = clickListener

            // Load image using Glide
            Glide.with(binding.thumnail.context)
                .load(newsItem.imageUrl)
                .into(binding.thumnail)

            binding.executePendingBindings()
        }
    }
}

