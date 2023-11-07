package edu.temple.funwithintents

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // This view contains the text to share
        val editText = findViewById<EditText>(R.id.editTextText)

        // When the user clicks this button, share the text
        findViewById<ImageButton>(R.id.shareImageButton).setOnClickListener {
            val textToShare  = editText.text.toString()

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, textToShare)
            }

            val shareIntent = Intent.createChooser(sendIntent,null)
            startActivity(shareIntent)

        }
    }
}