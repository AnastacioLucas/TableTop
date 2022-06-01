package com.udacity.tabletop.view.mainScreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//Use data binding to show the reminder on the item
class TableTopGamesPageAdapter(fragmentActivity: FragmentActivity, private var totalCount: Int) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewFragment()
            1 -> SecondFragment()
            2 -> ClosedFragment()
            else -> NewFragment()
        }
    }
}
