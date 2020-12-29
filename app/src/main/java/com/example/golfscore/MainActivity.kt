package com.example.golfscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener { view ->
            var username = etUsername.text.toString()
            var password = etPassword.text.toString()
            val intent = Intent(this, NavActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }

}