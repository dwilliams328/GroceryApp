package com.example.httprequest.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.httprequest.fragments.Cat1Fragment
import com.example.httprequest.fragments.Cat2Fragment
import com.example.httprequest.fragments.Cat3Fragment

class AdapterSubCategoryFragment(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Cat1Fragment()
            1 -> Cat2Fragment()
            else -> Cat3Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return  when(position){
            0 -> "One"
            1 -> "Two"
            else -> "Three"
        }
    }
}