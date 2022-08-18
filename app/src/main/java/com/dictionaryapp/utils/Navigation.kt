package com.dictionaryapp.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.dictionaryapp.R

fun FragmentActivity.replaceFragment(activity: FragmentActivity, fragment: Fragment) {
    activity.supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, fragment).commit()
}
