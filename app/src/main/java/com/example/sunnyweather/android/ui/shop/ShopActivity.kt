package com.example.sunnyweather.android.ui.shop

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.sunnyweather.R
import com.example.sunnyweather.android.SunnyWeatherApplication.Companion.context
import kotlinx.android.synthetic.main.activity_shop.*

class ShopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        toolbar.title="商店"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationIcon(R.drawable.icon_back)
        setSupportActionBar(toolbar)
        viewpager.adapter=ShopFragmentAdapter(supportFragmentManager, listOf("","","","",""))
        slidingtablayout.setViewPager(viewpager, arrayOf("全部","早餐","中餐","晚餐","宵夜"));
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_shop,menu)
        return true
    }




}