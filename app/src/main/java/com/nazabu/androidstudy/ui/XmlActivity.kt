package com.nazabu.androidstudy.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.nazabu.androidstudy.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class XmlActivity : AppCompatActivity(R.layout.activity_xml) {

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, XmlActivity::class.java)
    }
}