package com.nazabu.androidstudy.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nazabu.androidstudy.databinding.ActivityXmlBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class XmlActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    companion object {
        fun createIntent(context: Context): Intent = Intent(context, XmlActivity::class.java)
    }
}