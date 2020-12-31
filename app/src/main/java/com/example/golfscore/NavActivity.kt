package com.example.golfscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nav.*

class NavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)

        var user = intent.getStringExtra("username")
        tv_user.setText(user)

        btn_NewRecord.setOnClickListener{view ->
            val intent = Intent(this, NewScoreActivity::class.java)
            startActivity(intent)
        }
    }
}