package com.dictionaryapp.data.models.services

import android.util.Log
import com.dictionaryapp.data.models.DictionaryAPI
import com.dictionaryapp.data.models.NetworkResult
import com.dictionaryapp.utils.Constant
import com.google.gson.Gson
import okhttp3.OkHttpClient


object DictionaryService {
    private val client = OkHttpClient()
    fun getDictionary(word: String): NetworkResult<List<DictionaryAPI>> {
        val response = client.newCall(RequestBuilder.makeDictionaryAPIRequest(word)).execute()
        return if (response.isSuccessful) {
            val dictionaryModel = Gson().fromJson(response.body!!.string(), API::class.java)
            NetworkResult.Success(dictionaryModel)
        } else {
            NetworkResult.Fail(response.message)
        }

    }
}


