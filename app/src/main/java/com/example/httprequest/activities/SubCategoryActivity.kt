package com.example.httprequest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.httprequest.R
import com.example.httprequest.adapters.AdapterSubCategoryFragment
import com.example.httprequest.fragments.Cat1Fragment
import com.example.httprequest.fragments.Cat2Fragment
import com.example.httprequest.fragments.Cat3Fragment
import kotlinx.android.synthetic.main.activity_sub_category.*

class SubCategoryActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        init()
    }

    private fun init() {
        var adapterSubCategoryFragment = AdapterSubCategoryFragment(supportFragmentManager)
        view_pager.adapter = adapterSubCategoryFragment

        tab_layout.setupWithViewPager(view_pager)
    }
}