package com.dictionaryapp.fragments

import com.dictionaryapp.adapter.DefinitionsAdapter
import com.dictionaryapp.base_classes.BaseFragment
import com.dictionaryapp.data.models.Definitions
import com.dictionaryapp.databinding.WordDetailsFragmentBinding


class WordDetailsFragment : BaseFragment<WordDetailsFragmentBinding>() {
    override fun bindingInflater(): WordDetailsFragmentBinding =
        WordDetailsFragmentBinding.inflate(layoutInflater)

    override fun setup() {

    }

    private fun setupDefinitionsAdapter(definitions: List<Definitions>) {
        val definitionsAdapter = DefinitionsAdapter(definitions)
        binding.definitionsList.adapter = definitionsAdapter
    }

}