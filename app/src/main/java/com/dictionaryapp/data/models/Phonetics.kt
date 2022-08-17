package com.dictionaryapp.data.models

import com.google.gson.annotations.SerializedName


data class Phonetics(

    @SerializedName("text") var text: String? = null,
    @SerializedName("audio") var audio: String? = null,
    @SerializedName("sourceUrl") var sourceUrl: String? = null,
    @SerializedName("license") var license: License? = License()

)