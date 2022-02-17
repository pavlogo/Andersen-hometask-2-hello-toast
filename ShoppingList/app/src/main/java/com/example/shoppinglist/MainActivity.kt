package com.example.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addItem(view: View) {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
    val i = intent.getStringExtra("count")
    val mes = findViewById<TextView>(R.id.textView)
    mes.text = i
        }
}