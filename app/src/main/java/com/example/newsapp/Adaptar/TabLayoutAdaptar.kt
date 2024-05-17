package com.example.newsapp.Adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.newsapp.AllNewsTabFragment
import com.example.newsapp.PoliticsNewsTabFragment
import com.example.newsapp.R
import com.example.newsapp.SportNewsTabFragment

class TabLayoutAdaptar(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllNewsTabFragment()
            1 -> SportNewsTabFragment()
            else -> PoliticsNewsTabFragment()
        }
    }
}