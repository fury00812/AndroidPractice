package com.example.activity_to_activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button_main)
        button.setOnClickListener{
            val intent = Intent(this@MainActivity, SubActivity::class.java)
            startActivity(intent)
        }
    }
}