package com.fury.http_fuel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("onCreate:","aiueo")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 非同期処理①郵便番号
        // "http://zipcloud.ibsnet.co.jp/api/search".httpGet(listOf("zipcode" to "4418122")).responseJson { ...
        "http://zipcloud.ibsnet.co.jp/api/search?zipcode=4418122".httpGet().responseJson { request, response, result ->
            when (result) {
                is Result.Success -> {
                    Log.d("result", "通信に成功しました。")
                    val json = result.value.obj()
                    val results =json.get("results") as JSONArray
                    val data1 = results[0] as JSONObject
                    val address : String = data1["address1"] as String + data1["address2"] + data1["address3"]
                    Log.d("json","d:"+address)
                }
                is Result.Failure -> {
                    Log.d("result", "通信に失敗しました。")
                }
            }
        }

        // 非同期処理②JSON取得
        "http://fury.lomo.jp/practice/connect_database.php".httpGet().responseJson { request, response, result ->
            when (result) {
                is Result.Success -> {
                    Log.d("result", "通信に成功しました。")
                    val json : JSONArray = result.value.array()
                    Log.d("json","d:"+json)
                    var ishimori = json[0] as JSONObject
                    Log.d("json","d:"+ishimori)
                    Log.d("json","d:"+ishimori["name"])
//                    val results =json.get("results") as JSONArray
//                    Log.d("json","d:"+)
//                    val data1 = results[0] as JSONObject
//                    Log.d("json","d:"+address)
                }
                is Result.Failure -> {
                    Log.d("result", "通信に失敗しました。")
                }
            }
        }

        // 非同期処理③txt
        "http://fury.lomo.jp/keyaki_view/res/members/ishimori_nijika/urlList.txt".httpGet().responseString { request, response, result ->
            when(result){
                is Result.Success -> {
                    Log.d("result", "通信に成功しました。")
                    Log.d("result","txt:"+result.value)
                    var urlList = result.value.split("\n")
                    Log.d("urlList",""+urlList)

                }
                is Result.Failure -> {
                    Log.d("result", "通信に失敗しました。")
                }
            }
        }

        // 同期処理（エラー）
//        val triple = "http://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060".httpGet().response()
//        var result = triple.third.get()
//        Log.d("同期処理の結果：", "aiueo"+String(result))

    }
}
