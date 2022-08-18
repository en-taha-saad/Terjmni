package com.dictionaryapp.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WordDetails(
    var definitions: List<Definitions> = arrayListOf(),
    var synonyms: String? = null,
    var antonyms: String? = null,
) : Parcelable

