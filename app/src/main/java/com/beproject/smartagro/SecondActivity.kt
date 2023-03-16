package com.beproject.smartagro

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        val msg = intent.getStringExtra("msg")

        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(this));
        }

        val python = Python.getInstance()
        val pythonFile = python.getModule("haribol")
        val mantra = pythonFile.callAttr("haribol").toString()
        val textView: TextView = findViewById<TextView>(R.id.welcometext).apply {
            text = mantra
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}