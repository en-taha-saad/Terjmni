package com.dictionaryapp.data.services

import com.dictionaryapp.utils.Constant
import okhttp3.HttpUrl
import okhttp3.Request

object RequestBuilder {
    fun makeDictionaryAPIRequest(word: String): Request {
        val url = HttpUrl.Builder().scheme(Constant.SCHEMA).host(Constant.HOST)
            .addPathSegment(Constant.FIRST_PATH)
            .addPathSegment(Constant.SECOND_PATH)
            .addPathSegment(Constant.THIRD_PATH)
            .addPathSegment(Constant.FORTH_PATH)
            .addPathSegment(word)
            .build()

        return Request.Builder().url(url)
            .build()
    }

}