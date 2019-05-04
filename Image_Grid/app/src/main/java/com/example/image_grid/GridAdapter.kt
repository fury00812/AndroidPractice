package com.example.image_grid


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(context:Context, val layoutId:Int, idList:MutableList<Int>,
                  val names: List<String>) : BaseAdapter(){

    private var array_imageID : MutableList<Int> = mutableListOf()
    private val inflater : LayoutInflater

    // Viewを保持するクラスをここで定義してるだけ。使いまわすので少し軽くなるとか。
    // innerを付けることで外側クラスのメンバにアクセスできる
    internal inner class ViewHolder {
        // 型の後ろに"?"を付けるとnullableになる
        // nullかもしれないならつけとけばいい
        var imageView: ImageView? = null
        var textView: TextView? = null
    }

    init {
        // LayoutInflaterはレイアウトファイル(xml)を利用できる仕組み
        // レイアウトの中にレイアウトを置ける(inflate)
        // 今回はactivity_mainのGridViewにgrid_items.xmlをinflateする
        this.inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        array_imageID = idList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val holder: ViewHolder
        if (convertView == null) {
            // main.xml の <GridView .../> に grid_items.xml を inflate して convertView とする
            convertView = inflater.inflate(layoutId, parent, false)
            // ViewHolder を生成
            holder = ViewHolder()

            holder.imageView = convertView!!.findViewById(R.id.image_view)
            holder.textView = convertView.findViewById(R.id.text_view)

            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        holder.imageView?.setImageResource(array_imageID[position])
        holder.textView?.text = names[position]

        return convertView
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
