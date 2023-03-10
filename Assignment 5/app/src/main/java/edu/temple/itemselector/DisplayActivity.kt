package edu.temple.itemselector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity()
{
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

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
            imageView.setImageResource(image)
            textView.text = name
        }
    }
}