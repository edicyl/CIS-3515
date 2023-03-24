package edu.temple.itemselector

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity()
{
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageList: ArrayList<ImageItem>
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var textView: TextView

    companion object
    {
        lateinit var stringArray: Array<String>
        lateinit var foodArray: Array<String>
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        imageList = ArrayList()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        stringArray = resources.getStringArray(R.array.labels)
        foodArray = resources.getStringArray(R.array.foods)

        textView = findViewById(R.id.textView)
        textView.text = stringArray[0]

        imageList = arrayListOf(
            ImageItem(R.drawable.american, foodArray[0]),
            ImageItem(R.drawable.chinese, foodArray[1]),
            ImageItem(R.drawable.english, foodArray[2]),
            ImageItem(R.drawable.indian, foodArray[3]),
            ImageItem(R.drawable.italian, foodArray[4]),
            ImageItem(R.drawable.japanese, foodArray[5]),
            ImageItem(R.drawable.korean, foodArray[6]),
            ImageItem(R.drawable.mexican, foodArray[7]),
            ImageItem(R.drawable.south_african, foodArray[8]),
            ImageItem(R.drawable.vietnamese, foodArray[9])
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