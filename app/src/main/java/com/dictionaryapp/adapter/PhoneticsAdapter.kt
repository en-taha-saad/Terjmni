package com.dictionaryapp.adapter

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dictionaryapp.data.models.Phonetics
import com.dictionaryapp.databinding.SingleWordPhoneticBinding
import okio.IOException


class PhoneticsAdapter(
    private val phoneticsList: List<Phonetics>
) :
    RecyclerView.Adapter<PhoneticsAdapter.PhoneticViewHolder>() {
    private val mediaPlayer = MediaPlayer()


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
            phoneticWord.text = singlePhonetic.text
            phoneticAudio.setOnClickListener {
                singlePhonetic.audio?.let {
                    if (mediaPlayer.isPlaying) {
                        mediaPlayer.stop()
                        mediaPlayer.reset()
                        mediaPlayer.release()
                    }
                    playAudio(it)
                }
            }
        }

    }

    @Suppress("DEPRECATION")
    private fun playAudio(it: String) {
        mediaPlayer.setAudioStreamType(android.media.AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer.setDataSource(it)
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (error: IOException) {
            error.printStackTrace()
        }

    }


    override fun getItemCount() = phoneticsList.size

}