package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var EXTRA_MESSAGE = null
    private var mMessageEditText: EditText? = null
    private val LOG_TAG = MainActivity::class
    val TEXT_REQUEST = 1
    private var mReplyHeadTextView: TextView? = null
    private var mReplyTextView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG.toString(), "-------")
        Log.d(LOG_TAG.toString(), "onCreate")

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")

            if (isVisible) {
                val HTV = mReplyHeadTextView
                if (HTV != null) {
                    HTV.setVisibility(View.VISIBLE)
                }
                val TV = mReplyTextView
                if (TV != null) {
                    TV.setText(
                        savedInstanceState
                            .getString("reply_text")
                    )
                    TV.setVisibility(View.VISIBLE)
                }
            }
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mReplyHeadTextView!!.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString(
                "reply_text",
                mReplyTextView!!.text.toString()
            )
        }
    }

    fun launchSecondActivity(view: View?) {
        Log.d(LOG_TAG.toString(), "Button clicked!")

        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                mReplyHeadTextView!!.visibility = View.VISIBLE
                val reply = SecondActivity()
                mReplyTextView!!.text = reply.EXTRA_REPLY
                mReplyTextView!!.visibility = View.VISIBLE
            }
        }
    }
}
