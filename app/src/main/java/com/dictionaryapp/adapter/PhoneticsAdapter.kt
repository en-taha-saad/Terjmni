package com.dictionaryapp.adapter

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dictionaryapp.data.models.Phonetics
import com.dictionaryapp.databinding.SingleWordPhoneticBinding
import okio.IOException


class PhoneticsAdapter(
    private val phoneticsList: List<Phonetics>
) :
    RecyclerView.Adapter<PhoneticsAdapter.PhoneticViewHolder>() {
    private var context: android.content.Context? = null
    private var mediaPlayer = MediaPlayer()

    inner class PhoneticViewHolder(val binding: SingleWordPhoneticBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneticViewHolder {
        context = parent.context
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
                    mediaPlayer = MediaPlayer()
                    if (mediaPlayer.isPlaying) {
                        stopAudio()
                    } else {
                        playAudio(it)
                    }
                }
            }
        }

    }

    private fun stopAudio() {
        mediaPlayer.stop()
        mediaPlayer.reset()
        mediaPlayer.release()
    }

    @Suppress("DEPRECATION")
    private fun playAudio(it: String) {
        try {
            mediaPlayer.setAudioStreamType(android.media.AudioManager.STREAM_MUSIC)
            mediaPlayer.setDataSource(it)
            Toast.makeText(
                context,
                "please, wait while audio is loading",
                Toast.LENGTH_SHORT,
            ).show()
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (error: IOException) {

            Toast.makeText(
                context,
                "audio is not available",
                Toast.LENGTH_SHORT,
            ).show()
        }

    }

    override fun getItemCount() = phoneticsList.size

}