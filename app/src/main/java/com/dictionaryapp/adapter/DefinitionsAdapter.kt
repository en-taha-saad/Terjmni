package com.dictionaryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dictionaryapp.data.models.Definitions
import com.dictionaryapp.databinding.SingleDefinitionBinding


class DefinitionsAdapter(
    private val definitionsList: List<Definitions>
) :
    RecyclerView.Adapter<DefinitionsAdapter.DefinitionViewHolder>() {


    inner class DefinitionViewHolder(val binding: SingleDefinitionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionViewHolder {
        return DefinitionViewHolder(
            SingleDefinitionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DefinitionViewHolder, position: Int) {
        val singleDefinition = definitionsList[position]
        holder.binding.apply {

        }

    }

    override fun getItemCount() = definitionsList.size

}