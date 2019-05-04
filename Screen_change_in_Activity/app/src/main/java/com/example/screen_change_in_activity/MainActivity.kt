package com.example.screen_change_in_activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        set_main_screen()

    }

    private fun set_main_screen(){
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button_main)
        button.setOnClickListener {
            set_sub_screen()
        }
    }

    private fun set_sub_screen(){
        setContentView(R.layout.activity_sub)
        val button : Button = findViewById(R.id.button_main)
        button.setOnClickListener {
            set_main_screen()
        }
    }
}
