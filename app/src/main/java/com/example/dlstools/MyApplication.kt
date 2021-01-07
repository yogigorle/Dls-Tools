package com.example.dlstools

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext


    }

    companion object {

        var appContext: Context? = null

        val sharedPreferences: SharedPreferences by lazy {
            appContext!!.getSharedPreferences(
                "Dls Tools",
                Context.MODE_PRIVATE
            )
        }
    }
}