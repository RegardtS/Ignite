package com.modic.ignite.ui.sharewall

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.util.Log
import com.modic.ignite.R
import com.modic.ignite.ShareWallFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivityAlt : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

        topleft.setOnClickListener { startFragment(ShareWallFragment()) }
        topright.setOnClickListener { startFragment(ShareWallFragment())}
        midleft.setOnClickListener { startFragment(ShareWallFragment())}
        midright.setOnClickListener { startFragment(ShareWallFragment())}
        botleft.setOnClickListener { startFragment(ShareWallFragment())}
        botright.setOnClickListener { startFragment(ShareWallFragment())}
    }

    fun startFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().add(R.id.container,fragment,"test").addToBackStack(null).commit()
    }
}
