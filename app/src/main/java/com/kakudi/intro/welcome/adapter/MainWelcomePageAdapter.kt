package com.kakudi.intro.welcome.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
class MainWelcomePageAdapter(fragmentManager: FragmentManager) :
    FragmentStateAdapter(fragmentManager) {

    var fragmentList: List<Fragment> = emptyList()


    fun addFragment(fragment: Fragment) {
        fragmentList = fragmentList.plus(fragment)
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getItemCount(): Int = fragmentList.size

}