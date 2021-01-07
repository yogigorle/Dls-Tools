package com.example.dlstools

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_module1_contents.*

class Module1Contents : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module1_contents)


        rv_module_1.setHasFixedSize(true)
        rv_module_1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val toDoListItems = ArrayList<String>()

        toDoListItems.add("DAY 1 - GET, SET, GO!")
        toDoListItems.add("DAY 2 - The Winner's Mindset")
        toDoListItems.add("DAY - 3 Perfect Goal Setting")
        toDoListItems.add("DAY 4 - Suffocate Your Excuses")
        toDoListItems.add("DAY 5 - Motivation Is Useless")
        toDoListItems.add("DAY 6 - The Power of Rituals")
        toDoListItems.add("DAY 7 - Sunday Educational Surprise")
        toDoListItems.add("DAY 8 - The Perfect Daily Routine")
        toDoListItems.add("DAY 9 - Advanced Dopamine Detox")
        toDoListItems.add("DAY 10 - How To Befriend A Celebrity")

        val btnEntries = ArrayList<TodoListDataModel>()

        val adapter =
            TodolistCardViewAdapter(this, toDoListItems, btnEntries,"Module1Position")

        rv_module_1.setItemViewCacheSize(toDoListItems.size)

        rv_module_1.adapter = adapter

        btn_go_back.setOnClickListener {
            finish()
        }


    }

}