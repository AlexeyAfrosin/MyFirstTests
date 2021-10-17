package com.afrosin.myfirsttests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.afrosin.myfirsttests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val vb: ActivityMainBinding by viewBinding()
    private val emailValidator = EmailValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(vb) {
            emailInput.addTextChangedListener(emailValidator)

            saveButton.setOnClickListener {
                if (emailValidator.isValid) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.valid_email),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val errorEmail = getString(R.string.invalid_email)
                    emailInput.error = errorEmail
                    Toast.makeText(this@MainActivity, errorEmail, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}