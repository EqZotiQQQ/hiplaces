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
    val LOG_TAG = "TEST_LOG SignUpActivity"
    lateinit var emailField: EditText
    lateinit var passwordField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        init()
    }

    private fun init() {
        emailField = findViewById(R.id.edit_text_sign_in_email_name)
        passwordField = findViewById(R.id.edit_text_sign_in_password)
    }

    fun onClick(v: View) {
        Log.d(LOG_TAG, "fun onClick(${v.id})");
        val emailValue = emailField.text.toString()
        val passwordValue = passwordField.text.toString()
        when(v.id) {
            R.id.button_sign_in_apply -> {
                if(emailValue.isEmpty() || passwordValue.isEmpty()) {
                    Toast.makeText(this, "Field is empty!", Toast.LENGTH_SHORT).show()
                    return
                }
                val packedSignInData = boxTheData()
                Log.d(LOG_TAG, "json: $packedSignInData")
                val sender = Sender(packedSignInData, "signin")
                sender.send()
            }
            R.id.button_sign_in_cancel -> {
                finish()
            }
        }
    }

    fun boxTheData(): String {
        val signInBoxedData = SignInBoxedData(
            emailField.text.toString(),
            passwordField.text.toString())
        val json = Json(JsonConfiguration.Stable)
        return json.stringify(SignInBoxedData.serializer(), signInBoxedData)
    }
}

