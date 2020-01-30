package com.example.ice_game

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //画面遷移ボタンを取得
        val startBtn = findViewById<Button>(R.id.startbtn)
        //startbtnを押したときの処理
        startBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity,Game_Screen::class.java)
                startActivity(intent)
            }
        })



    }

}
