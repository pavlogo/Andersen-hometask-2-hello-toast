package com.example.andersenhometask2helloConstraint

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import com.example.andersenhometask2.R


class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private var mShowCount: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countUp(view: View) {
        mCount++
        if (mShowCount != null) mShowCount!!.text = mCount.toString()

        val countButton: Button = findViewById(R.id.button_count)
        if (mCount % 2 == 0) countButton.setBackgroundColor(Color.BLUE)
        if (mCount % 2 == 1) countButton.setBackgroundColor(Color.MAGENTA)

        val zeroButton: Button = findViewById(R.id.zero)
        if (mCount > 0) zeroButton.setBackgroundColor(Color.GREEN)
    }

    fun makeZero(view: View) {
        mCount = 0
        mShowCount!!.text = mCount.toString()
        val countButton: Button = findViewById(R.id.button_count)
        val zeroButton: Button = findViewById(R.id.zero)
        zeroButton.setBackgroundColor(Color.LTGRAY)
        countButton.setBackgroundColor(Color.BLUE)
    }
}