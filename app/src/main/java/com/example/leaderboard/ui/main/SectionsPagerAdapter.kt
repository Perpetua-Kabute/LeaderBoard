package com.example.leaderboard.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.leaderboard.R
import com.example.leaderboard.ui.main.PlaceholderFragment.Companion.newInstance
import java.lang.reflect.Array.newInstance

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return 2 fragment
        when (position) {
            0 -> return PlaceholderFragment.newInstance(0)
            1 -> return SkillIqFragment.newInstance(1)
            else -> return null!!
        }
    }


    override fun getPageTitle(position: Int): CharSequence? {
        //title here
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}