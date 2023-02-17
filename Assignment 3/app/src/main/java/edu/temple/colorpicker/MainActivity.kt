package edu.temple.colorpicker

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = arrayOf("Black", "Blue", "Cyan", "Green", "Grey", "Lime", "Maroon", "Olive", "Red", "Silver", "White", "Yellow")

        val spinner = findViewById<Spinner>(R.id.spinner)
        val canvas = findViewById<View>(R.id.colorDisplay)

        spinner.adapter = ColorAdapter(this, colors)

        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
            {
                p0?.run{
                    val color = getItemAtPosition(p2).toString()
                    canvas.setBackgroundColor(Color.parseColor(color))
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?)
            {
                p0?.run{
                    canvas.setBackgroundColor(Color.parseColor("White"))
                }
            }
        }
    }
}

class ColorAdapter(_context: Context, _colors: Array<String>) : BaseAdapter()
{
    private val context = _context
    private val colors = _colors

    override fun getCount(): Int
    {
        return colors.size
    }

    override fun getItem(p0: Int): Any
    {
        return colors[p0]
    }

    override fun getItemId(p0: Int): Long
    {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        val textView : TextView

        if (p1 != null)
        {
            textView = p1 as TextView
            textView.text = colors[p0]
        }

        else
        {
            textView = TextView(context)
            textView.textSize = 22f
            textView.setPadding(5, 10, 0, 10)
            textView.text = context.getString(R.string.colorChoose)
        }

        textView.setBackgroundColor(Color.parseColor("White"))

        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        val textView : TextView

        if (convertView != null)
        {
            textView = convertView as TextView
        }

        else
        {
            textView = TextView(context)
            textView.textSize = 22f
            textView.setPadding(5, 10, 0, 10)
        }

        textView.text = colors[position]

        if (position == 0)
        {
            textView.setTextColor(Color.parseColor("White"))
        }

        else if (position == 10)
        {
            textView.setTextColor(Color.parseColor("Black"))
        }

        textView.setBackgroundColor(Color.parseColor(colors[position]))

        return textView
    }
}