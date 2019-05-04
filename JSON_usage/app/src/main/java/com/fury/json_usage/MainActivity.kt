package com.fury.json_usage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.httpGet
import org.json.JSONArray
import org.json.JSONObject
import com.github.kittinunf.result.Result

class MainActivity : AppCompatActivity() {

    var namelist : MutableList<String> = mutableListOf<String>()
    var idlist : MutableList<String> = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        "http://fury.lomo.jp/practice/connect_database.php".httpGet().responseJson { request, response, result ->
            when (result) {
                is Result.Success -> {
                    Log.d("result", "通信に成功しました。")
                    val json : JSONArray = result.value.array()
                    for (i in 0..(json.length() - 1)) {
                        var member = json[i] as JSONObject
                        namelist.add(member["name"] as String)
                        idlist.add(member["id"] as String)
                    }
                    Log.d("result","namelist:"+namelist)
                    Log.d("result","idlist:"+idlist)
                }
                is Result.Failure -> {
                    Log.d("result", "通信に失敗しました。")
                }
            }
        }
    }
}
