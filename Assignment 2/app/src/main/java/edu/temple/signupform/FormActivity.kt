package edu.temple.signupform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class FormActivity : AppCompatActivity()
{
    private lateinit var textInputName: TextInputLayout
    private lateinit var textInputEmail: TextInputLayout
    private lateinit var textInputPassword: TextInputLayout
    private lateinit var textInputConfirm: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInputName = findViewById(R.id.text_input_name)
        textInputEmail = findViewById(R.id.text_input_email)
        textInputPassword = findViewById(R.id.text_input_password)
        textInputConfirm = findViewById(R.id.text_input_confirm)
    }

    fun confirmSave(view: View)
    {

    }
}