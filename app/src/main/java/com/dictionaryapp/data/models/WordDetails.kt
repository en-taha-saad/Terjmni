package com.dictionaryapp.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class WordDetails(
    var definitions: @RawValue List<Definitions> = mutableListOf(),
    var synonyms: String? = null,
    var antonyms: String? = null,
) : Parcelable

