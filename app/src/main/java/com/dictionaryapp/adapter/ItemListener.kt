package com.dictionaryapp.adapter

import com.dictionaryapp.data.models.WordDetails


interface ItemListener {
    fun onClickItem(wordDetails: WordDetails)
}