package com.example.picasso_local

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.content.Context.WINDOW_SERVICE
import android.view.WindowManager
import android.graphics.Point;
import android.util.Log
import com.squareup.picasso.Picasso;

class GridAdapter(context: Context, val layoutId:Int, idList:MutableList<Int>) : BaseAdapter(){

    private var array_imageID : MutableList<Int> = mutableListOf()
    private val inflater : LayoutInflater
    private var ScreenWidthHalf = 0
    private var ScreenWidthOneThird = 0

    init {
        // LayoutInflaterはレイアウトファイル(xml)を利用できる仕組み
        // レイアウトの中にレイアウトを置ける(inflate)
        // 今回はactivity_mainのGridViewにgrid_items.xmlをinflateする
        this.inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        array_imageID = idList

        // 画面の横幅の半分を計算
        val wm = context.getSystemService(WINDOW_SERVICE) as WindowManager
        if (wm != null) {
            val disp = wm.defaultDisplay
            val size = Point()
            disp.getSize(size)

            val screenWidth = size.x
            ScreenWidthHalf = screenWidth / 2
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
            .load(array_imageID[position])
            .resize(ScreenWidthOneThird, ScreenWidthOneThird)
            .centerCrop()
            .into(img)

        return view
    }

    override fun getCount(): Int {
        // List<Int> array_imageID の全要素数を返す
        return array_imageID.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

}