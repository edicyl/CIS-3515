package edu.temple.itemselector

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity()
{
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageList: ArrayList<ImageItem>
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        imageList = ArrayList()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        imageList = arrayListOf(
            ImageItem(R.drawable.american, "American:\nBurger"),
            ImageItem(R.drawable.chinese, "Chinese:\nDumplings"),
            ImageItem(R.drawable.english, "English:\nEnglish Breakfast"),
            ImageItem(R.drawable.indian, "Indian:\nCurry"),
            ImageItem(R.drawable.italian, "Italian:\nSpaghetti"),
            ImageItem(R.drawable.japanese, "Japanese:\nRamen"),
            ImageItem(R.drawable.korean, "Korean:\nBibimbap"),
            ImageItem(R.drawable.mexican, "Mexican:\nTacos"),
            ImageItem(R.drawable.south_african, "South African:\nBobotie"),
            ImageItem(R.drawable.vietnamese, "Vietnamese:\nPho")
        )

        imageAdapter = ImageAdapter(imageList)
        recyclerView.adapter = imageAdapter

        imageAdapter.onImageClick = {
            val intent = Intent(this, DisplayActivity::class.java).apply {
                putExtra("image", it)
                putExtra("name", imageList[imageList.indexOfFirst { image -> image.image == it }].name)
            }
            startActivity(intent)
        }
    }
}