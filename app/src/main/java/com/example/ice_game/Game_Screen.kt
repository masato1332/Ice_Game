package com.example.ice_game

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.ActionBarDrawerToggle
import android.widget.Button
import kotlinx.android.synthetic.main.game__screen.*


class Game_Screen() : Activity() {

    val handler = Handler()
    var timeValue = 0
    var count = 0
    var ctime = ""




    override public fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game__screen)

        handler.post(runnable)

        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener() {

            count = count + 1
            count_text.setText(count.toString())

            ctime = timeValue.toString()


            if (count == 16){
                handler.removeCallbacks(runnable)
                val intent = Intent(this@Game_Screen,Result::class.java)
                ctime = ctime.toString()
                intent.putExtra("ctime", ctime)


               startActivity(intent)
            }
        }





    }


    //時間計測部分
    val runnable = object : Runnable {
        // メッセージ受信が有った時
        override fun run() {


            timeValue++                      // 秒カウンタ+1
            timeToText(timeValue)?.let {
                // timeToText()で表示データを作り
                timeText.text = it            // timeText.textへ代入(表示)
            }
            handler.postDelayed(this, 1000)  // 1000ｍｓ後に自分にpost
        }
    }

}

    private fun timeToText(time: Int = 0): String? {
        return if (time < 0) {
            null                                    // 時刻が0未満の場合 null
        } else if (time == 0) {
            "00:00:00"                            // ０なら
        } else {
            val h = time / 3600
            val m = time % 3600 / 60
            val s = time % 60
            "%1$02d:%2$02d:%3$02d".format(h, m, s)  // 表示に整形
        }
    }



