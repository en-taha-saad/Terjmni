package com.dictionaryapp.data.services

import com.dictionaryapp.data.NetworkResult
import com.dictionaryapp.data.models.DictionaryAPI
import com.google.gson.Gson
import okhttp3.OkHttpClient

class API : ArrayList<DictionaryAPI>()

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


