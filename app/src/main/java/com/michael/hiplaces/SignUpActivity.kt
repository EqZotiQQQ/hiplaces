package com.michael.hiplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {
    val LOG_TAG = "TEST_LOG SignUpActivity"
    lateinit var emailField: EditText
    lateinit var passwordField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }

    private fun init() {
        emailField = findViewById(R.id.fieldLogInName)
        passwordField = findViewById(R.id.fieldLogInPassword)
    }

    fun onClick(v: View) {
        Log.d(LOG_TAG, "fun onClick(${v.id})");
        val emailValue = emailField.text.toString()
        val passwordValue = passwordField.text.toString()
        when(v.id) {
            R.id.btnLogInApply -> {
                if(emailValue.isEmpty() || passwordValue.isEmpty()) {
                    Toast.makeText(this, "Field is empty!", Toast.LENGTH_SHORT).show()
                    return
                }
                sentRequest()
            }
            R.id.btnLogInCancel -> {
                finish()
            }
        }
    }

    private fun sentRequest() {
        Log.d(LOG_TAG, "fun sentRequest");
        val signUpBoxedData = SignUpBoxedData(
                            emailField.text.toString(),
                            passwordField.text.toString())
        val json = Json(JsonConfiguration.Stable)
        val jsonSignUpBoxedData = json.stringify(SignUpBoxedData.serializer(), signUpBoxedData)
        Log.d(LOG_TAG, "jsonBox: ${jsonSignUpBoxedData}")
    }
}
