package com.dictionaryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dictionaryapp.data.models.Meanings
import com.dictionaryapp.data.models.Phonetics
import com.dictionaryapp.databinding.SingleMeaningCardBinding
import com.dictionaryapp.databinding.SingleWordPhoneticBinding


class PhoneticsAdapter(
    private val phoneticsList: List<Phonetics>
) :
    RecyclerView.Adapter<PhoneticsAdapter.PhoneticViewHolder>() {


    inner class PhoneticViewHolder(val binding: SingleWordPhoneticBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneticViewHolder {
        return PhoneticViewHolder(
            SingleWordPhoneticBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhoneticViewHolder, position: Int) {
        val singlePhonetic = phoneticsList[position]
        holder.binding.apply {

        }

    }

    override fun getItemCount() = phoneticsList.size

}