package com.example.ice_game

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.result_screen.*
import java.lang.IllegalArgumentException


class Result: Activity() {
    var name = ""

    var cleartime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_screen)

        val intent = getIntent()
        var ctime = intent.getStringExtra("ctime")

        //ctimeにデータを入れる

        clearTime.setText(ctime + "秒")


        cleartime = ctime.toInt()


        resultBtn.setOnClickListener() {
            name = editText.text.toString()

            val post = AsyncHttp(name,cleartime)
            post.execute()
        }

    }

}


