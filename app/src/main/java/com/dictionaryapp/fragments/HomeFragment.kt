package com.dictionaryapp.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dictionaryapp.base_classes.BaseFragment
import com.dictionaryapp.databinding.HomeFragmentBinding


class HomeFragment : BaseFragment<HomeFragmentBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> HomeFragmentBinding =
        HomeFragmentBinding::inflate


    override fun setup() {
    }


}