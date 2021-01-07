package com.example.dlstools

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()


        val spannableText = SpannableStringBuilder(getString(R.string.made_text))
        spannableText.setSpan(
            ForegroundColorSpan(Color.RED),
            10, 11,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE

        )

        tv_made_in.text = spannableText

        Handler(Looper.getMainLooper()).postDelayed({
            launchActivity<MainActivity>()
        }, 2500)


    }


}