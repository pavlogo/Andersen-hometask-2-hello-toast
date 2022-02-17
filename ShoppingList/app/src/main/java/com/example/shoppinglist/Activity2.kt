package com.example.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Activity2 : AppCompatActivity() {

    var itemName: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val intent = intent
        itemName = findViewById(R.id.buttonPanel)
    }

    fun fillItem(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        val message = itemName!!.text.toString()
        intent.putExtra("count", message)
        finish()
    }
}