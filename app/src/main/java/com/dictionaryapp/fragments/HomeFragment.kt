package com.dictionaryapp.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.dictionaryapp.base_classes.BaseFragment
import com.dictionaryapp.data.models.DictionaryAPI
import com.dictionaryapp.data.models.DictionaryDataManager
import com.dictionaryapp.data.models.NetworkResult
import com.dictionaryapp.databinding.HomeFragmentBinding
import com.dictionaryapp.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<HomeFragmentBinding>() {

    private val dictionaryDataManager = DictionaryDataManager()
    private var word: String = "hi"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> HomeFragmentBinding =
        HomeFragmentBinding::inflate


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
        binding.word.text = dictionary.word
    }

    private fun onResponseLoading() {

    }

    private fun onResponseFail(message: String) {
        Log.i(Constant.TAG, message)
    }

}