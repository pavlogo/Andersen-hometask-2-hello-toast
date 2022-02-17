package com.example.andersenhometask2

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var mCount = 0
    var mShowCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View) {
//        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
//        toast.show()
        val intent = Intent(this, Activity2::class.java)
        val message = mShowCount!!.text.toString()
        intent.putExtra("count", message)
        startActivity(intent)
    }


    @SuppressLint("SetTextI18n")
    fun countUp(view: View?) {
        mCount++
        if (mShowCount != null) mShowCount!!.text = mCount.toString()
    }
}
