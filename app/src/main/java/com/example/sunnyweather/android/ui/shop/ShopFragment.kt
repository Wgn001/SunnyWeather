package com.example.sunnyweather.android.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sunnyweather.R
import com.jay.widget.StickyHeadersLinearLayoutManager
import kotlinx.android.synthetic.main.shop_fragment.*

class ShopFragment : Fragment() {

    private lateinit var adapter: ShopAdapter

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
        val list= listOf<String>("","","","","","","","","")
        adapter=ShopAdapter(context!!,list)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter
    }



}