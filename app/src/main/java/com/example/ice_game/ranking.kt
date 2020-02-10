package com.example.ice_game

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.ranking_view.*

class ranking : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ranking_view)

        webView.loadUrl("http://10.206.0.104/Ice_Game/Ranking.php")
    }

}