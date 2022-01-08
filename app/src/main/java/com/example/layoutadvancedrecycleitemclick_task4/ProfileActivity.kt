package com.example.layoutadvancedrecycleitemclick_task4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initView()

    }

    private fun initView() {
        val textView = findViewById<TextView>(R.id.text_main)
        val text = intent.getSerializableExtra("key")
        textView.text = text.toString()
    }
}