package com.dictionaryapp


import android.view.LayoutInflater
import com.dictionaryapp.base_classes.BaseActivity
import com.dictionaryapp.databinding.ActivityMainBinding
import com.dictionaryapp.utils.Navigation

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val inflate: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    override fun setup() {
        Navigation.replaceFragment(HomeFragment())
    }

}