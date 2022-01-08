package com.example.layoutadvancedrecycleitemclick_task4

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.layoutadvancedrecycleitemclick_task4.adapter.Adapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var itemList: ArrayList<User>
    private lateinit var recyclerViewAdapter: Adapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        refreshAdapter(addUsers())
    }

    private fun addUsers(): ArrayList<User> {
        itemList = ArrayList()
        for (i in 0..50) {
            itemList.add(User(random(), "$i"))
        }
        return itemList
    }

    private fun random(): String {
        val names = arrayListOf("Java", "Kotlin", "Android", "Flutter", "Dart")
        return names[(0 until names.size).random()]
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        recyclerViewAdapter = Adapter(this, users, object : Adapter.OnMyItemClickListener {
            override fun myItemClick(user: User) {
                startActivity(Intent(this@MainActivity, ProfileActivity::class.java).apply {
                    putExtra("key", user)
                })

            }
        })
        recyclerView.adapter = recyclerViewAdapter
    }
}