package com.dictionaryapp


import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.dictionaryapp.base_classes.BaseActivity
import com.dictionaryapp.databinding.ActivityMainBinding
import com.dictionaryapp.fragments.HomeFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val inflate: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    override fun setup() {

        navToFragment(HomeFragment())
    }


    private fun navToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment).commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            super.onBackPressed()
        }
    }


}