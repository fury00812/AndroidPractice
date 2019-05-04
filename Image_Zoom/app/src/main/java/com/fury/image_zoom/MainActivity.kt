package com.fury.image_zoom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.chrisbanes.photoview.PhotoView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var photoView: PhotoView = PhotoView(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        photoView = findViewById(R.id.photo_view)
        photoView.setImageResource(R.drawable.i8)

    }
}
