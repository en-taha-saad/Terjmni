package com.dictionaryapp.utils

import androidx.fragment.app.Fragment
import com.dictionaryapp.R

object Navigation {

    fun replaceFragment(fragment: Fragment) {
        fragment.requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
    }
}
