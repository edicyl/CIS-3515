package edu.temple.itemselector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import edu.temple.itemselector.SelectionActivity.Companion.stringArray

class DisplayActivity : AppCompatActivity()
{
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val image = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")

        if (image != 0)
        {
            imageView = findViewById(R.id.imageFullView)
            textView = findViewById(R.id.imageText)
            exitButton = findViewById(R.id.buttonExit)

            imageView.setImageResource(image)
            textView.text = name
            exitButton.text = stringArray[1]

            val exitButton = findViewById<TextView>(R.id.buttonExit)
            exitButton.setOnClickListener {
                finish()
            }
        }
    }
}