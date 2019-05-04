package com.example.picasso_server

import android.content.Context
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.BaseAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class GridAdapter(context: Context, val layoutId:Int, imageList:List<String>) : BaseAdapter() {

    private var array_image : List<String> = listOf()
    private val inflater : LayoutInflater
    private var ScreenWidthOneThird = 0

    init {
        // LayoutInflaterはレイアウトファイル(xml)を利用できる仕組み
        // レイアウトの中にレイアウトを置ける(inflate)
        // 今回はactivity_mainのGridViewにgrid_items.xmlをinflateする
        this.inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        array_image = imageList

        // 画面の横幅の半分を計算
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        if (wm != null) {
            val disp = wm.defaultDisplay
            val size = Point()
            disp.getSize(size)

            val screenWidth = size.x
            ScreenWidthOneThird = screenWidth /3
            Log.d("debug", "ScreenWidthOneThird=$ScreenWidthOneThird")
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null) {
            // main.xml の <GridView .../> に grid_items.xml を inflate して convertView とする
            view = inflater.inflate(layoutId, parent, false)
        } else {
            view = convertView
        }

        val img = view!!.findViewById<ImageView>(R.id.image_view)
        img.setScaleType(ImageView.ScaleType.CENTER_CROP)

        Picasso.get()
            .load(addUrl(position))
            .resize(ScreenWidthOneThird, ScreenWidthOneThird)
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher)
            .centerCrop()
            .into(img)

        return view
    }

    fun addUrl(position: Int): String{
        return "http://fury.lomo.jp/practice/Images/%s.jpg".format(array_image[position])
    }

    override fun getCount(): Int {
        // List<Int> array_image の全要素数を返す
        return array_image.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
}
