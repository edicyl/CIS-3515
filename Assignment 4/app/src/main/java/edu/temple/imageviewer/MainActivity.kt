package edu.temple.imageviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity()
{
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageList: ArrayList<ImageItem>
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageList = ArrayList()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        // val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        // 10 images
        /*imageList.add(R.drawable.bear)
        imageList.add(R.drawable.capybara)
        imageList.add(R.drawable.cat)
        imageList.add(R.drawable.dog)
        imageList.add(R.drawable.fox)
        imageList.add(R.drawable.lion)
        imageList.add(R.drawable.owl)
        imageList.add(R.drawable.panda)
        imageList.add(R.drawable.parrot)
        imageList.add(R.drawable.turtle)*/

        imageList = arrayListOf(
            ImageItem(R.drawable.bear, "Bear"),
            ImageItem(R.drawable.capybara, "Capybara"),
            ImageItem(R.drawable.cat, "Cat"),
            ImageItem(R.drawable.dog, "Dog"),
            ImageItem(R.drawable.fox, "Fox"),
            ImageItem(R.drawable.lion, "Lion"),
            ImageItem(R.drawable.owl, "Owl"),
            ImageItem(R.drawable.panda, "Panda"),
            ImageItem(R.drawable.parrot, "Parrot"),
            ImageItem(R.drawable.turtle, "Turtle")
        )

        imageAdapter = ImageAdapter(imageList)
        recyclerView.adapter = imageAdapter

        imageAdapter.onImageClick = {
            val intent = Intent(this, ImageDetail::class.java).apply {
                putExtra("image", it)
                putExtra("name", imageList[imageList.indexOfFirst { image -> image.image == it }].name)
            }
            startActivity(intent)
        }
    }
}