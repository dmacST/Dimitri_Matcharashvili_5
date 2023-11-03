package com.example.dimitri_matcharashvili_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        val nextButton = findViewById<Button>(R.id.nextButton2)
        nextButton.setOnClickListener {
            val firstName = intent.getStringExtra("firstName")
            val lastName = findViewById<EditText>(R.id.lastNameEditText).text.toString()


            val intent = Intent(this, ThirdPageActivity::class.java).apply {
                putExtra("firstName", firstName)
                putExtra("lastName", lastName)

            }




            startActivity(intent)
        }
    }
}
