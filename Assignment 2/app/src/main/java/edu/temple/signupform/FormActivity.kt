package edu.temple.signupform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

    private fun validateName(): Boolean
    {
        val nameInput = textInputName.editText?.text.toString().trim()

        return if (nameInput.isEmpty())
        {
            textInputName.error = "Field can't be empty!"
            false
        } else
        {
            textInputName.error = null
            true
        }
    }

    private fun validateEmail(): Boolean
    {
        val emailInput = textInputEmail.editText?.text.toString().trim()

        return if (emailInput.isEmpty())
        {
            textInputEmail.error = "Field can't be empty!"
            false
        } else
        {
            textInputEmail.error = null
            true
        }
    }

    private fun validatePassword(): Boolean
    {
        val passInput = textInputPassword.editText?.text.toString().trim()

        return if (passInput.isEmpty())
        {
            textInputPassword.error = "Field can't be empty!"
            false
        } else
        {
            textInputPassword.error = null
            true
        }
    }

    private fun validateConfirm(): Boolean
    {
        val passConfirmInput = textInputConfirm.editText?.text.toString().trim()

        return if (passConfirmInput.isEmpty())
        {
            textInputConfirm.error = "Field can't be empty!"
            false
        } else
        {
            textInputConfirm.error = null
            true
        }
    }

    private fun validatePassSame(): Boolean
    {
        val passInput = textInputPassword.editText?.text.toString().trim()
        val passConfirmInput = textInputConfirm.editText?.text.toString().trim()

        return if (passInput == passConfirmInput)
        {
            true
        } else
        {
            textInputPassword.error = "Passwords don't match!"
            textInputConfirm.error = "Passwords don't match!"
            false
        }
    }

    fun confirmSave(view: View)
    {
        var isValid = true

        if (!validateName()) isValid = false
        if (!validateEmail()) isValid = false
        if (!validatePassword()) isValid = false
        if (!validateConfirm()) isValid = false
        if (!validatePassSame()) isValid = false

        if (!isValid)
        {
            return
        }

        val welcome = "Welcome, " + textInputName.editText?.text.toString() + ", to the app!"

        Toast.makeText(this, welcome, Toast.LENGTH_SHORT).show()
    }
}