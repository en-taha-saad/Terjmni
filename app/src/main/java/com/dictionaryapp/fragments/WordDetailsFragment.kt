package com.dictionaryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dictionaryapp.adapter.DefinitionsAdapter
import com.dictionaryapp.base_classes.BaseFragment
import com.dictionaryapp.data.models.Definitions
import com.dictionaryapp.data.models.WordDetails
import com.dictionaryapp.databinding.WordDetailsFragmentBinding


class WordDetailsFragment : BaseFragment<WordDetailsFragmentBinding>() {
    override fun bindingInflater(): WordDetailsFragmentBinding =
        WordDetailsFragmentBinding.inflate(layoutInflater)

    private var argumentsFromHome: WordDetails? = null

    override fun setup() {
        argumentsFromHome = arguments?.getParcelable(KEY)!!
        bindData(argumentsFromHome)
    }


    private fun bindData(args: WordDetails?) {
        setupDefinitionsAdapter(args?.definitions ?: emptyList())
        binding.apply {
            backButton.setOnClickListener {
                removeFragment(this@WordDetailsFragment)
            }
            antonymsStringValue.text = args?.antonyms
            synonymsStringValue.text = args?.synonyms
        }
    }


    private fun setupDefinitionsAdapter(definitions: List<Definitions>) {
        val definitionsAdapter = DefinitionsAdapter(definitions)
        binding.definitionsList.adapter = definitionsAdapter
    }


    private fun removeFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .remove(fragment).commit()
    }


    companion object {
        fun newInstance(wordDetails: WordDetails) = WordDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY, wordDetails)
            }
        }

        private const val KEY = "word_details"
    }

}