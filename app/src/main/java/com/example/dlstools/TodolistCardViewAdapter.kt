package com.example.dlstools

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView


class TodolistCardViewAdapter(
    val context: Context,
    val todoItems: ArrayList<String>,
    val btnEntries: ArrayList<TodoListDataModel>,
    val key: String
) :
    RecyclerView.Adapter<TodolistCardViewAdapter.ViewHolder>() {


    class ViewHolder(
        itemView: View,
        val btnEntries: ArrayList<TodoListDataModel>,
        val key: String
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        lateinit var todoText: TextView
        lateinit var btnCheckBox: LottieAnimationView
        lateinit var rl_todoItem: RelativeLayout


        init {
            todoText = itemView.findViewById(R.id.tv_todo_item)
            btnCheckBox = itemView.findViewById(R.id.btn_check_box)
            rl_todoItem = itemView.findViewById(R.id.rl_todoItem)

            btnCheckBox.setOnClickListener(this)
            rl_todoItem.setOnClickListener(this)


        }


        override fun onClick(view: View?) {

            when (view?.id) {
                R.id.btn_check_box -> {
                    if (getBoolean("$key$adapterPosition")) {
                        btnCheckBox.speed = -3.5f
                        btnCheckBox.playAnimation()
                        setStrikeThroughText(todoText)
                        putBoolean(
                            "$key$adapterPosition",
                            false
                        )
                        Log.e(
                            "Unclicked at $adapterPosition",
                            "${getBoolean("$key$adapterPosition")}"
                        )
                    } else {
                        btnCheckBox.speed = 3f
                        btnCheckBox.playAnimation()
                        setStrikeThroughText(todoText)
                        putBoolean(
                            "$key$adapterPosition",
                            true
                        )
                        Log.e(
                            "CLicked at $adapterPosition",
                            "${getBoolean("$key$adapterPosition")}"
                        )
                    }
                }

                R.id.rl_todoItem -> {
                    if (getBoolean("$key$adapterPosition")) {
                        btnCheckBox.speed = -3.5f
                        btnCheckBox.playAnimation()
                        setStrikeThroughText(todoText)
                        putBoolean(
                            "$key$adapterPosition",
                            false
                        )
                        Log.e(
                            "Unclicked at $adapterPosition",
                            "${getBoolean("$key$adapterPosition")}"
                        )
                    } else {
                        btnCheckBox.speed = 3f
                        btnCheckBox.playAnimation()
                        setStrikeThroughText(todoText)
                        putBoolean(
                            "$key$adapterPosition",
                            true
                        )
                    }
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.cv_todo_list_items, parent, false)
        return ViewHolder(layout, btnEntries, key)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.todoText.text = todoItems[position]
        Log.e("TodoAdapter", "the value at position$position is ${getBoolean("position$position")}")

        if (getBoolean("$key$position")) {
            Log.e("TodoAdapter", "checked at $position")
            holder.btnCheckBox.frame = 75
            setStrikeThroughText(holder.todoText)
        } else {
            Log.e("TodoAdapter", "unchecked at $position")
            holder.btnCheckBox.frame = 0
        }


    }


}

