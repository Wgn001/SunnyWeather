package com.example.sunnyweather.android.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.sunnyweather.R
import com.jay.widget.StickyHeadersLinearLayoutManager
import kotlinx.android.synthetic.main.now.*
import kotlinx.android.synthetic.main.shop_fragment.*

class ShopFragment : Fragment() {

    private lateinit var adapter: ShopAdapter

    val shopViewModel by lazy {
        ViewModelProviders.of(this).get(ShopViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager=StickyHeadersLinearLayoutManager<ShopAdapter>(activity)
        adapter=ShopAdapter(this,shopViewModel)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter
        swipeRefresh.setOnRefreshListener {
            shopViewModel.changeRecommend(20)
            swipeRefresh.isRefreshing=false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            shopViewModel.recommendLiveData.observe(this){
            shopViewModel.recommendList.clear();
            shopViewModel.recommendList.addAll(shopViewModel.recommendLiveData.value!!)
            adapter.notifyDataSetChanged()
        }
    }





}