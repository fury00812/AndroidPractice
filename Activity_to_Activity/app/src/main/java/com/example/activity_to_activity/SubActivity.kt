package com.example.activity_to_activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val button : Button = findViewById(R.id.button_sub)
        button.setOnClickListener {
            val intent = Intent(this@SubActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}