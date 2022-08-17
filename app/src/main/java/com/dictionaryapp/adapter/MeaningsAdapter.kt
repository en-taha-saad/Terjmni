package com.dictionaryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dictionaryapp.data.models.Meanings
import com.dictionaryapp.databinding.SingleMeaningCardBinding


class MeaningsAdapter(
    private val meaningsList: List<Meanings>,
    private val itemListener: ItemListener
) :
    RecyclerView.Adapter<MeaningsAdapter.MeaningViewHolder>(), ListAdapter {


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
        holder.binding.apply {
            singleMeaningCard.setOnClickListener {
                itemListener.onClickItem(singleMeaning)
            }
        }

    }

    override fun getItemCount() = meaningsList.size

}