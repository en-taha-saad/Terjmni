package com.dictionaryapp.fragments

import com.dictionaryapp.base_classes.BaseFragment
import com.dictionaryapp.databinding.WordDetailsFragmentBinding


class WordDetailsFragment : BaseFragment<WordDetailsFragmentBinding>() {
    override fun bindingInflater(): WordDetailsFragmentBinding =
        WordDetailsFragmentBinding.inflate(layoutInflater)

    override fun setup() {

    }


}