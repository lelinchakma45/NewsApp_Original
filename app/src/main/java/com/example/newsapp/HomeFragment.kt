package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Adaptar.NewsAdapter
import com.example.newsapp.Adaptar.TrendingDataAdaptar
import com.example.newsapp.Model.NewsProperty
import com.example.newsapp.ViewModel.HomeViewModel
import com.example.newsapp.ViewModel.NewsClickListener
import com.example.newsapp.ViewModel.TrendingData
import com.example.newsapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var viewModelAdapter: NewsAdapter? = null
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, HomeViewModel.Factory(requireActivity().application)).get(HomeViewModel::class.java)
    }
    private val localNewsData = listOf(
        NewsProperty("Title 1", "https://example.com/image1.jpg",""),
        NewsProperty("Title 2", "https://example.com/image2.jpg",""),
        NewsProperty("Title 3", "https://example.com/image3.jpg","")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        trendingDataShow()
        setUpTabLayout()
        setupObservers()
        setupCategoryButtons()
        return binding.root
    }

    private fun trendingDataShow() {
        binding.trendingNewsList.layoutManager = LinearLayoutManager(requireContext(),
            RecyclerView.HORIZONTAL, false)
        val listofItem = ArrayList<TrendingData>()

        listofItem.add(TrendingData(
            1,
            R.drawable.poster,
            R.drawable.profile_photo,
            "Swati Maliwal assault case: NCW summons Delhi CM Arvind Kejriwal's former PS Bibhav Kumar",
            "",
            "Lelin Chakma",
            "2 minute ago",
            1,
            1
        ))
        listofItem.add(TrendingData(
            2,
            R.drawable.poster,
            R.drawable.profile_photo,
            "Swati Maliwal assault case: NCW summons Delhi CM Arvind Kejriwal's former PS Bibhav Kumar",
            "",
            "Lelin Chakma",
            "2 minute ago",
            1,
            1
        ))
        listofItem.add(TrendingData(
            3,
            R.drawable.poster,
            R.drawable.profile_photo,
            "Swati Maliwal assault case: NCW summons Delhi CM Arvind Kejriwal's former PS Bibhav Kumar",
            "",
            "Lelin Chakma",
            "2 minute ago",
            1,
            1
        ))

        val myList = TrendingDataAdaptar(listofItem)
        binding.trendingNewsList.adapter = myList
    }

    private fun setUpTabLayout() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Setup RecyclerView
        viewModelAdapter = NewsAdapter(NewsClickListener { news ->
            viewModel.onItemSelected(news)
        })

        binding.rvRegular.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = viewModelAdapter
        }
    }

    private fun setupObservers() {
        viewModel.listNewsTechnology.observe(viewLifecycleOwner, Observer { news ->
            news?.let { viewModelAdapter?.news = it }
        })
    }

    private fun setupCategoryButtons() {
        binding.ctgrEntertain.setOnClickListener {
            switchContent("Entertain")
            setActiveButton(binding.ctgrEntertain)
        }
        binding.ctgrTechnology.setOnClickListener {
            switchContent("Tech")
            setActiveButton(binding.ctgrTechnology)
        }
        binding.ctgrBusiness.setOnClickListener {
            switchContent("Business")
            setActiveButton(binding.ctgrBusiness)
        }
        binding.ctgrHealth.setOnClickListener {
            switchContent("Health")
            setActiveButton(binding.ctgrHealth)
        }
        binding.ctgrSport.setOnClickListener {
            switchContent("Sport")
            setActiveButton(binding.ctgrSport)
        }
        binding.ctgrScience.setOnClickListener {
            switchContent("Science")
            setActiveButton(binding.ctgrScience)
        }
    }

    private fun setActiveButton(activeButton: Button) {
        val buttons = listOf(binding.ctgrEntertain, binding.ctgrTechnology, binding.ctgrBusiness,
            binding.ctgrHealth, binding.ctgrSport, binding.ctgrScience)

        buttons.forEach { it.setBackgroundResource(R.drawable.no_active) }
        activeButton.setBackgroundResource(R.drawable.active)
    }

    private fun switchContent(category: String) {
        val liveData = when (category) {
            "Tech" -> viewModel.listNewsTechnology
            "Entertain" -> viewModel.listEntertain
            "Business" -> viewModel.listBusiness
            "Health" -> viewModel.listHealth
            "Sport" -> viewModel.listSport
            "Science" -> viewModel.listScience
            else -> viewModel.listNewsTechnology
        }

        liveData.observe(viewLifecycleOwner, Observer { news ->
            news?.let { viewModelAdapter?.news = it }
        })
    }
}