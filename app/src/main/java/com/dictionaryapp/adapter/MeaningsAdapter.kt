package com.dictionaryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dictionaryapp.data.models.Meanings
import com.dictionaryapp.data.models.WordDetails
import com.dictionaryapp.databinding.SingleMeaningCardBinding
import com.dictionaryapp.utils.getAllDefinitions
import com.dictionaryapp.utils.putAorAnToWord
import com.dictionaryapp.utils.sureThatItIsNotEmpty


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

    override fun getItemCount() = meaningsList.size

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        val singleMeaning = meaningsList[position]
        var synonyms = ""
        var antonyms = ""
        holder.binding.apply {
            wordCard.text = word
            wordMeaning.text = putAorAnToWord(singleMeaning.partOfSpeech ?: "")

            synonyms = sureThatItIsNotEmpty(singleMeaning, synonyms)
            antonyms = sureThatItIsNotEmpty(singleMeaning, antonyms)

            navigateToWordDetails.setOnClickListener {
                itemListener.onClickItem(
                    WordDetails(
                        getAllDefinitions(meaningsList), synonyms, antonyms,
                    )
                )

            }
        }

    }


}