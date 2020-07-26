package com.michael.hiplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.serialization.*
import kotlinx.serialization.json.*


class SignUpActivity : AppCompatActivity() {

    val LOG_TAG = "TEST_LOG SignInActivity"

    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var repeatPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }

    /* init the edit text fields */
    private fun init() {
        name = findViewById(R.id.edit_text_sign_up_name)
        email = findViewById(R.id.edit_text_sign_up_email)
        password = findViewById(R.id.edit_text_sign_up_password)
        repeatPassword = findViewById(R.id.edit_text_sign_up_password_repeat)
    }

    /* button callback */
    fun onClick(v: View) {
        val sName = name.text.toString()
        val sEmail = email.text.toString()
        val sPassword = password.text.toString()
        val sRepeatPassword = repeatPassword.text.toString()
        when (v.id) {
            R.id.button_sign_up_apply -> {
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
                val packedSignUpData = boxTheData()
                Log.d(LOG_TAG, "json: $packedSignUpData")
                val sender = Sender(packedSignUpData, "signup")
                sender.send()
            }
            R.id.button_sign_up_cancel -> {
                finish()
            }
        }
    }

    fun boxTheData(): String {
        val signUpBoxedData = SignUpBoxedData(
            name.text.toString(),
            email.text.toString(),
            password.text.toString()
        )
        val json = Json(JsonConfiguration.Stable)
        return json.stringify(SignUpBoxedData.serializer(), signUpBoxedData)
    }
}


