package com.example.sunnyweather.android.ui.shop

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class ShopFragmentAdapter(private val fm :FragmentManager, private val list:List<String>):FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return list.size
    }


    override fun getItem(position: Int): Fragment {
        return ShopFragment()
    }

}