package com.example.dlstools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import kotlinx.android.synthetic.main.activity_about_me.*

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        iv_profile.load("https://i.ibb.co/zRkqZmM/yogi-profile-pic-circle.png")

        btn_go_back_abt_me.setOnClickListener {
            finish()
        }
    }
}