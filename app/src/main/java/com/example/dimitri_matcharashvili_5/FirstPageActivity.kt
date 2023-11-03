package com.example.dimitri_matcharashvili_5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FirstPageActivity : AppCompatActivity() {
    private lateinit var timeTextView: TextView

    private val timeUpdateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val currentTime = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date())
            timeTextView.text = "Current Date and Time: $currentTime"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        timeTextView = findViewById(R.id.timeTextView)

        updateTimeDisplay()

        val intentFilter = IntentFilter(Intent.ACTION_TIME_TICK)
        registerReceiver(timeUpdateReceiver, intentFilter)

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {

            val firstName = findViewById<EditText>(R.id.firstNameEditText).text.toString()

            val intent = Intent(this, SecondPageActivity::class.java).apply {
                putExtra("firstName", firstName)
            }

            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeUpdateReceiver)
    }

    private fun updateTimeDisplay() {
        val currentTime = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date())
        timeTextView.text = "Current Date and Time: $currentTime"
    }
}
