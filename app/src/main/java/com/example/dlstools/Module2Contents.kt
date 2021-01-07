package com.example.dlstools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_module1_contents.*
import kotlinx.android.synthetic.main.activity_module2_contents.*

class Module2Contents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module2_contents)

        rv_module_2.setHasFixedSize(true)
        rv_module_2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val toDoListItems = ArrayList<String>()

        toDoListItems.add("DAY 11 - Your LIFE MAP")
        toDoListItems.add("DAY 12 - Your SOUL MAP Part 1")
        toDoListItems.add("DAY 13 - Your SOUL MAP Part 2")
        toDoListItems.add("DAY 14 - Sunday Educational Surprise")
        toDoListItems.add("DAY 15 - Your HEALTH MAP Part-1")
        toDoListItems.add("DAY 16 - Your HEALTH MAP Part 2")
        toDoListItems.add("DAY 17 - Your MONEY MAP Part 1")
        toDoListItems.add("DAY 18 - Your MONEY MAP Part-2")
        toDoListItems.add("DAY 19 - Your MASTERY MAP")
        toDoListItems.add("DAY 20 - Make MONEY Today")

        val btnEntries = ArrayList<TodoListDataModel>()

        val adapter =
            TodolistCardViewAdapter(this, toDoListItems, btnEntries,"Module2Position")

        rv_module_2.setItemViewCacheSize(toDoListItems.size)

        rv_module_2.adapter = adapter

        btn_go_back_module2.setOnClickListener {
            finish()
        }

    }
}