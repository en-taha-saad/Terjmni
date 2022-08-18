package com.dictionaryapp


import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.dictionaryapp.base_classes.BaseActivity
import com.dictionaryapp.databinding.ActivityMainBinding
import com.dictionaryapp.fragments.HomeFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val inflate: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    override fun setup() {
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
    }

}