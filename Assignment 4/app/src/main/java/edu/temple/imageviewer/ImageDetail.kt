package edu.temple.imageviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ImageDetail : AppCompatActivity()
{
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        val image = intent.getIntExtra("image", 0)

        if (image != 0)
        {
            imageView = findViewById(R.id.imageFullView)
            textView = findViewById(R.id.imageText)
            imageView.setImageResource(image)
        }
    }
}