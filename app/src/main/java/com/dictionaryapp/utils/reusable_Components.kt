package com.dictionaryapp.utils

import android.view.View
import com.dictionaryapp.data.models.Definitions
import com.dictionaryapp.data.models.Meanings

fun sureThatItIsNotEmpty(
    singleMeaning: Meanings,
    varToBeSureFor: String
): String {
    var varToBeSureThrough = varToBeSureFor
    if (singleMeaning.synonyms.isNotEmpty()) {
        varToBeSureThrough = singleMeaning.synonyms.joinToString(separator = "\n") { it }
    }
    return varToBeSureThrough
}

fun getAllDefinitions(meaningsList: List<Meanings>): List<Definitions> {
    val definitionsList = mutableListOf<Definitions>()
    meaningsList.map { meanings ->
        meanings.definitions.map { definition ->
            definitionsList.add(definition)
        }
    }
    return definitionsList
}


fun putAorAnToWord(word: String): String {
    return if (word.startsWith("a") || word.startsWith("e") || word.startsWith(
            "i"
        ) || word.startsWith("o") || word.startsWith("u")
    ) {
        "an $word"
    } else {
        "a $word"
    }
}


 fun View.hide() {
    this.visibility = View.GONE
}

 fun View.show() {
    this.visibility = View.VISIBLE
}

