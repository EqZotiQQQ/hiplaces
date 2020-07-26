package com.michael.hiplaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View) {
        when(v.id) {
            R.id.button_main_to_sign_in_activity -> {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }
            R.id.button_main_to_sign_up_activity -> {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
