package com.dictionaryapp.data.models

import com.google.gson.annotations.SerializedName


data class License(

    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)