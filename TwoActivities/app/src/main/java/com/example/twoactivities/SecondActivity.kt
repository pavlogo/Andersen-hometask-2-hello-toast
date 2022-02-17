package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    var EXTRA_REPLY = null
    private var mReply: EditText? = null
    private val LOG_TAG = SecondActivity::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mReply = findViewById(R.id.editText_second)

        val intent = intent
        val textView = findViewById<TextView>(R.id.text_message)
        val message = MainActivity()
        textView.text = message.EXTRA_MESSAGE
    }


    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG.toString(), "onStart")
    }
    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG.toString(), "onPause")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG.toString(), "onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG.toString(), "onResume")
    }
    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG.toString(), "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG.toString(), "onDestroy")
    }


    fun returnReply(view: View) {
        val reply = mReply!!.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        Log.d(LOG_TAG.toString(), "End SecondActivity");
        finish()
    }
}