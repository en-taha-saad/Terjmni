package com.dictionaryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dictionaryapp.data.models.Definitions
import com.dictionaryapp.data.models.Meanings
import com.dictionaryapp.databinding.SingleMeaningCardBinding


class MeaningsAdapter(
    private val word: String,
    private val meaningsList: List<Meanings>,
    private val itemListener: ItemListener
) :
    RecyclerView.Adapter<MeaningsAdapter.MeaningViewHolder>() {


    inner class MeaningViewHolder(val binding: SingleMeaningCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
        return MeaningViewHolder(
            SingleMeaningCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        val singleMeaning = meaningsList[position]
        // merge two lists into one list
        val definitionsList = mutableListOf<Definitions>()
        definitionsList
        holder.binding.apply {
            singleMeaningCard.setOnClickListener {
                itemListener.onClickItem(singleMeaning)
            }
            wordCard.text = word
            wordMeaning.text = putAorAnToWord(singleMeaning.partOfSpeech ?: "")
            navigateToWordDetails.setOnClickListener {

            }
        }

    }

    private fun putAorAnToWord(word: String): String {
        if (word.startsWith("a") || word.startsWith("e") || word.startsWith(
                "i"
            ) || word.startsWith("o") || word.startsWith("u")
        ) {
            return "an $word"
        } else {
            return "a $word"
        }
    }


    override fun getItemCount() = meaningsList.size

}