package com.example.dlstools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_module3_contents.*

class Module3Contents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module3_contents)

        rv_module_3.setHasFixedSize(true)
        rv_module_3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val toDoListItems = ArrayList<String>()

        toDoListItems.add("DAY 21 - Sunday Educational Surprise")
        toDoListItems.add("DAY 22 - Procrastination Killer Hacks")
        toDoListItems.add("DAY 23 - 3X Your Focus Technique")
        toDoListItems.add("DAY 24 - Declutter Your Life")
        toDoListItems.add("DAY 25 - Boxed Time Technique")
        toDoListItems.add("DAY 26 - 3 Apps To Boost Productivity")
        toDoListItems.add("DAY 27 - Vomit Marathon Technique")
        toDoListItems.add("DAY 28 - Sunday Educational Surprise")
        toDoListItems.add("DAY 29 - Become A Human Computer")
        toDoListItems.add("DAY 30 - The Secret Session")

        val btnEntries = ArrayList<TodoListDataModel>()

        val adapter =
            TodolistCardViewAdapter(this, toDoListItems, btnEntries, "Module3Position")

        rv_module_3.setItemViewCacheSize(toDoListItems.size)

        rv_module_3.adapter = adapter

        btn_go_back_module3.setOnClickListener {
            finish()
        }

    }
}