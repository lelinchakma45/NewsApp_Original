package com.example.newsapp.Adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.ViewModel.TrendingData
import com.example.newsapp.databinding.HomeTrendingCardBinding

class TrendingDataAdaptar(private val itemList:ArrayList<TrendingData>): RecyclerView.Adapter<TrendingDataAdaptar.TrendingNewsViewHolder>() {
    class TrendingNewsViewHolder(val binding: HomeTrendingCardBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingNewsViewHolder {
        return TrendingNewsViewHolder(HomeTrendingCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TrendingNewsViewHolder, position: Int) {
        val menuItem = itemList[position]
        holder.binding.apply {
            newsCover.setImageResource(menuItem.news_cover)
            newsTitle.text = menuItem.news_title
            newsAuthorProfile.setImageResource(menuItem.author_cover)
            newsAuthorName.text = menuItem.news_author_name
            timeShow.text = menuItem.news_upload_time
            viewerShow.text = menuItem.news_see_count.toString()
            commentCount.text = menuItem.news_comment_count.toString()
        }
    }
}