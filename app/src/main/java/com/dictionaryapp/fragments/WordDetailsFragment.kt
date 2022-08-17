package com.dictionaryapp.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dictionaryapp.base_classes.BaseFragment
import com.dictionaryapp.databinding.WordDetailsFragmentBinding


class WordDetailsFragment : BaseFragment<WordDetailsFragmentBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> WordDetailsFragmentBinding =
        WordDetailsFragmentBinding::inflate


    override fun setup() {

    }


}