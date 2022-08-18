package com.dictionaryapp.base_classes

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dictionaryapp.R

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    abstract fun setup()
    abstract val inflate: (LayoutInflater) -> VB
    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_DictionaryApp)
        super.onCreate(savedInstanceState)
        _binding = inflate(layoutInflater)
        setContentView(_binding.root)
        setup()

    }


}