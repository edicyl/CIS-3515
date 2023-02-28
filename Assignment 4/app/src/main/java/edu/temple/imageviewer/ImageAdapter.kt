package edu.temple.imageviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val imageList: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>()
{
    class ImageViewHolder(imageView: View) : RecyclerView.ViewHolder(imageView)
    {
        val imageView: ImageView = imageView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder
    {
        val imgView = LayoutInflater.from(parent.context).inflate(R.layout.image_display, parent, false)

        return ImageViewHolder(imgView)
    }

    override fun getItemCount(): Int
    {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int)
    {
        holder.imageView.setImageResource(imageList[position])
    }
}