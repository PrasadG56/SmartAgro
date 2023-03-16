package com.beproject.smartagro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.senddata)
        button.setOnClickListener{
            Log.i("Main Activity", "Data send to next activity")
            val view_msg: TextView = findViewById(R.id.messagefield)
            val message: String = view_msg.text.toString()
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

            val intent = Intent(this,SecondActivity::class.java).also {
                it.putExtra("msg",message)
                startActivity(it)
            }
//            startActivity(intent)
//            intent.putExtra("msg"
        //            ,message)
        }

    }
}