package com.example.image_grid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView


class SingleImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_image)

        val intent = intent
        val imageId = intent.getIntExtra("IMAGEID", 0)

        val imageView = findViewById<ImageView>(R.id.image_view)
        imageView.setImageResource(imageId)
    }
}
