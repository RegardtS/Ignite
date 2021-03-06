package com.modic.ignite

import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.modic.ignite.ui.band.BandFragment
import com.modic.ignite.ui.events.EventFragment
import com.modic.ignite.ui.info.InfoFragment
import com.modic.ignite.ui.media.MediaFragment
import com.modic.ignite.ui.social_media.SocialMediaFragment
import com.modic.ignite.ui.young_adults.YoungAdultsFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)


        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> InfoFragment()
                1 -> EventFragment()
                2 -> YoungAdultsFragment()
                3 -> SocialMediaFragment()
                4 -> MediaFragment()
                5 -> BandFragment()
                6 -> ShareWallFragment()
                else -> PlaceholderFragment.newInstance(position)
            }
        }

        override fun getCount(): Int = 7
    }

    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {

            val layoutInt = when(arguments?.getInt(ARG_SECTION_NUMBER)){
                0 -> R.layout.fragment_events
                1 -> R.layout.fragment_events
                2 -> R.layout.fragment_events
                3 -> R.layout.fragment_events
                4 -> R.layout.fragment_events
                5 -> R.layout.fragment_events
                6 -> R.layout.fragment_events
                else -> R.layout.fragment_events
            }


            return inflater.inflate(layoutInt, container, false)
        }

        companion object {

            private const val ARG_SECTION_NUMBER = "section_number"

            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
