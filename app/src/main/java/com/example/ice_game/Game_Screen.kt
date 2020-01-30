package com.example.ice_game

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.game__screen.*


class Game_Screen : Activity() {

    val handler : Handler()
    var timeValue = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game__screen)

        val runnable = object : Runnable {
            // メッセージ受信が有った時
            override fun run() {
                timeValue++                      // 秒カウンタ+1
                timeToText(timeValue)?.let {        // timeToText()で表示データを作り
                    timeText.text = it            // timeText.textへ代入(表示)
                }
                handler.postDelayed(this, 1000)  // 1000ｍｓ後に自分にpost
            }
        }

        handler.post(runnable)

        stop.setOnClickListener {
            handler.removeCallbacks(runnable)
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


}
