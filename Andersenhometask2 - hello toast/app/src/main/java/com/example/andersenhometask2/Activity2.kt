package com.example.andersenhometask2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val i = intent.getStringExtra("count")
        val mes = findViewById<TextView>(R.id.show_count2)
        mes.text = i
    }
}