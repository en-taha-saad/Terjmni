package com.dictionaryapp.data.models

import com.google.gson.annotations.SerializedName


data class Meanings(
    @SerializedName("partOfSpeech") var partOfSpeech: String? = null,
    @SerializedName("definitions") var definitions: ArrayList<Definitions> = arrayListOf(),
    @SerializedName("synonyms") var synonyms: ArrayList<String> = arrayListOf(),
    @SerializedName("antonyms") var antonyms: ArrayList<String> = arrayListOf()

)