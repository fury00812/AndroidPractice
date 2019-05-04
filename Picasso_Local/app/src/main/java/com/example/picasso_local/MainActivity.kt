package com.example.picasso_local

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    // 表示する画像の名前
    private var array_image : List<String> = listOf("i0","i1","i2","i3","i4","i5","i6","i7","i8","i9")

    // 画像のID
    // "java.util.ArrayList<Int> " ≒ "MutableList<Int>"
    private var array_imgID : MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // for-each member名をR.drawable.名前としてintに変換してarrayに登録
        for (image in array_image) {
            // 文字列からリソースidを取得
            val imageId = resources.getIdentifier(
                image, "drawable", packageName
            )
            array_imgID.add(imageId)
        }

        // GridViewのインスタンスを生成
        val gridview = findViewById<GridView>(R.id.gridview)
        // BaseAdapter を継承したGridAdapterのインスタンスを生成
        // 子要素のレイアウトファイル grid_items.xml を
        // activity_main.xml に inflate するためにGridAdapterに引数として渡す
        val adapter = GridAdapter(
            this.applicationContext,
            R.layout.grid_items,
            array_imgID
        )

        // gridViewにadapterをセット
        gridview.setAdapter(adapter)
        /*
        gridview.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(application, SingleImageActivity::class.java)
            intent.putExtra("IMAGEID", array_imgID.get(position))
            startActivity(intent)
        }
        */
    }
}
