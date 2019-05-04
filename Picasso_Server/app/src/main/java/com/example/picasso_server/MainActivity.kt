package com.example.picasso_server

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    // 表示する画像の名前
    private var array_image : List<String> = listOf("i0","i1","i2","i3","i4","i5","i6","i7","i8","i9")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // GridViewのインスタンスを生成
        val gridview = findViewById<GridView>(R.id.gridview)
        // BaseAdapter を継承したGridAdapterのインスタンスを生成
        // 子要素のレイアウトファイル grid_items.xml を
        // activity_main.xml に inflate するためにGridAdapterに引数として渡す
        val adapter = GridAdapter(
            this.applicationContext,
            R.layout.grid_items,
            array_image
        )

        // gridViewにadapterをセット
        gridview.setAdapter(adapter)
    }
}
