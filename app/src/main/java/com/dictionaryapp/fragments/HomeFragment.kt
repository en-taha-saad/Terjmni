package com.dictionaryapp.fragments

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.dictionaryapp.adapter.ItemListener
import com.dictionaryapp.adapter.MeaningsAdapter
import com.dictionaryapp.base_classes.BaseFragment
import com.dictionaryapp.data.DictionaryDataManager
import com.dictionaryapp.data.NetworkResult
import com.dictionaryapp.data.models.DictionaryAPI
import com.dictionaryapp.data.models.Meanings
import com.dictionaryapp.databinding.HomeFragmentBinding
import com.dictionaryapp.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<HomeFragmentBinding>(), ItemListener {
    override fun bindingInflater(): HomeFragmentBinding =
        HomeFragmentBinding.inflate(layoutInflater)


    private val dictionaryDataManager = DictionaryDataManager()
    private var word: String = "hi"


    override fun setup() {
        getDictionaryData()
    }

    private fun getDictionaryData() {
        lifecycleScope.launch(Dispatchers.Main) {
            dictionaryDataManager.getDictionary(word).collect(::onGetResponse)
        }
    }

    private fun onGetResponse(state: NetworkResult<List<DictionaryAPI>>) {
        when (state) {
            is NetworkResult.Fail -> onResponseFail(state.message)
            is NetworkResult.Loading -> onResponseLoading()
            is NetworkResult.Success -> onResponseSuccess(state.data[0])
        }
    }

    private fun onResponseSuccess(dictionary: DictionaryAPI) {
        setupMeaningsAdapter(dictionary.meanings)

        binding.word.text = dictionary.word
    }

    private fun setupMeaningsAdapter(meanings: List<Meanings>) {
        val meaningsAdapter = MeaningsAdapter(meanings, this)
        binding.meanings.adapter = meaningsAdapter
    }

    private fun onResponseLoading() {

    }

    private fun onResponseFail(message: String) {
        Log.i(Constant.TAG, message)
    }

    override fun onClickItem(singleMeaning: Meanings) {
    }

}