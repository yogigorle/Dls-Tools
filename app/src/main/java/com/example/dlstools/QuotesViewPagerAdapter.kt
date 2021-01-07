package com.example.dlstools

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class QuotesViewPagerAdapter(fragmentManager: FragmentManager, val Images: ArrayList<String>) :
    FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
        return QuotesFragment.newInstance(Images[position])
    }

    override fun getCount(): Int {
        return Images.size
    }


}