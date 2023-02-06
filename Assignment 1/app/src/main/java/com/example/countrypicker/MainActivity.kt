package com.example.countrypicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    private lateinit var textView: TextView
    private lateinit var numberPicker: NumberPicker
    private lateinit var countries: Array<String>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        numberPicker = findViewById(R.id.numberPicker)
        countries = resources.getStringArray(R.array.countries)

        numberPicker.minValue = 0
        numberPicker.maxValue = 19
        numberPicker.displayedValues = countries
        textView.text = resources.getString(R.string.user_location, countries[numberPicker.value])

        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            textView.text = resources.getString(R.string.user_location, countries[newVal])
        }
    }
}