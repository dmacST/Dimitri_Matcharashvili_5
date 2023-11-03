package com.example.dimitri_matcharashvili_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ThirdPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_page)

        val finishButton = findViewById<Button>(R.id.finishButton)
        finishButton.setOnClickListener {
            val personalId = findViewById<EditText>(R.id.personalIdEditText).text.toString()

            val firstName = intent.getStringExtra("firstName")
            val lastName = intent.getStringExtra("lastName")

            val intent = Intent(this, SummaryActivity::class.java).apply {
                putExtra("firstName", firstName)
                putExtra("lastName", lastName)
                putExtra("personalId", personalId)
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }

            startActivity(intent)
        }
    }
}
