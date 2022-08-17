package com.dictionaryapp.adapter

import com.dictionaryapp.data.models.Meanings


interface ItemListener {
    fun onClickItem(singleMeaning: Meanings)
}