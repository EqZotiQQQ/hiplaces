package com.michael.hiplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.serialization.*
import kotlinx.serialization.json.*


class SignInActivity : AppCompatActivity() {

    val LOG_TAG = "TEST_LOG SignInActivity"

    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var repeatPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        init()
    }

    private fun init() {
        name = findViewById(R.id.fieldName)
        email = findViewById(R.id.fieldEmail)
        password = findViewById(R.id.fieldRegPassword)
        repeatPassword = findViewById(R.id.fieldRegRePassword)
    }

    fun onClick(v: View) {
        val sName = name.text.toString()
        val sEmail = email.text.toString()
        val sPassword = password.text.toString()
        val sRepeatPassword = repeatPassword.text.toString()
        when (v.id) {
            R.id.btnRegAppy -> {
                if (sName.isEmpty() ||
                    sEmail.isEmpty() ||
                    sPassword.isEmpty() ||
                    sRepeatPassword.isEmpty()
                ) {
                    Toast.makeText(this, "Field is empty!", Toast.LENGTH_SHORT).show()
                    return
                }

                if (sPassword != sRepeatPassword) {
                    Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
                    return
                }

                sentRequest()
            }
            R.id.btnRegCancel -> {
                finish()
            }
        }
    }

    private fun sentRequest() {
        Log.d(LOG_TAG, "fun sentRequest");
        val signInBoxedData = SignInBoxedData(
                            name.text.toString(),
                            email.text.toString(),
                            password.text.toString(),
                            repeatPassword.text.toString())
        val json = Json(JsonConfiguration.Stable)
        val jsonSignInBoxedData = json.stringify(SignInBoxedData.serializer(), signInBoxedData)
        Log.d(LOG_TAG, "jsonBox: ${jsonSignInBoxedData}")
    }
}