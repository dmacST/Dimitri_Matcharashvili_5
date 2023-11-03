package com.example.dimitri_matcharashvili_5

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val personalId = intent.getStringExtra("personalId")

        val firstNameTextView = findViewById<TextView>(R.id.firstNameTextView)
        val lastNameTextView = findViewById<TextView>(R.id.lastNameTextView)
        val personalIdTextView = findViewById<TextView>(R.id.personalIdTextView)

        firstNameTextView.text = "First Name: $firstName"
        lastNameTextView.text = "Last Name: $lastName"
        personalIdTextView.text = "Personal ID: $personalId"
    }
}
