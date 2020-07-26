package com.michael.hiplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

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
             //   sentRequest()
            }
            R.id.button_sign_in_cancel -> {
                finish()
            }
        }
    }

   /* fun processData(): String {
        val signUpBoxedData = SignUpBoxedData(
            emailField.text.toString(),
            passwordField.text.toString())
        val json = Json(JsonConfiguration.Stable)
        return json.stringify(SignUpBoxedData.serializer(), signUpBoxedData)

    }*/

    /*
    * send data to the server
    **/
  /*  private fun sentRequest() {
        Log.d(LOG_TAG, "fun sentRequest");
        val jsonSignUpBoxedData = processData()
        sendHttp(jsonSignUpBoxedData)
        Log.d(LOG_TAG, "jsonBox: ${jsonSignUpBoxedData}")
    }

    fun sendHttp(jsonSignUpBoxedData: String) {
        Log.d(LOG_TAG, "sendHttp")
        val url = URL("http://37.195.44.14/")
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            val wr = OutputStreamWriter(outputStream)
            wr.write(jsonSignUpBoxedData)
            wr.flush()
            Log.d(LOG_TAG, "url:=$url outstream:=$wr")
            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                Log.d(LOG_TAG, "Response: $response")
            }
        }

    }*/
}

