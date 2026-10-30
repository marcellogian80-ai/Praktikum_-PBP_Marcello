
package com.gian.pratikumd1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize components
        val etNama = findViewById<EditText>(R.id.etNama)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnForm = findViewById<Button>(R.id.btnForm)
        val btnBrowser = findViewById<Button>(R.id.btnBrowser)

        // Toast Button
        btnToast.setOnClickListener {
            Toast.makeText(
                this,
                "Toast button clicked successfully!",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Explicit Intent with validation
        btnForm.setOnClickListener {
            val name = etNama.text.toString().trim()

            // Validation: Check if EditText is empty
            if (name.isEmpty()) {
                etNama.error = "Name is required!"

                Toast.makeText(
                    this,
                    "Please fill in your name first!",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                // Move activity (Explicit Intent) with data passed
                val intent = Intent(this, FormActivity::class.java)
                intent.putExtra("EXTRA_SENDER", name)
                startActivity(intent)
            }
        }

        // Implicit Intent (open URL in external browser)
        btnBrowser.setOnClickListener {
            val query = "https://akprind.ac.id"

            val intent = Intent(
                Intent.ACTION_VIEW,
                query.toUri()
            )

            startActivity(intent)
        }
    }
}
