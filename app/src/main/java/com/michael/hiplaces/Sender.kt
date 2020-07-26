package com.michael.hiplaces

import android.os.AsyncTask
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import java.lang.Exception

class Sender(val data: String, val type: String) {
    val LOG_TAG = "TEST_LOG Sender!!"
    fun send() {
        try {
            if (type == "signin") {
                val worker = SenderAsyncLog()
                worker.execute(data)
            } else if (type == "signup") {
                val worker = SenderAsyncPost()
                worker.execute(data)
            } else {
                Log.d(LOG_TAG, "Wrong http method")
            }
        } catch(e: Exception) {
            e.printStackTrace()
        }
    }
}

class SenderAsyncLog : AsyncTask<String, Void, String>() {
    val LOG_TAG = "TEST_LOG SenderAsync"
    override fun doInBackground(vararg params: String?): String? {
        for(param in params) {
            if(param!=null) {
                sendRequestOverFuel(param)
            }
        }
        return null
    }

    fun sendRequestOverFuel(data: String) {
        val re = Fuel.post("http://37.195.44.14:7878/api/v1/users/login")
            .header("Content-Type", "application/json")
            .body(data)
            .response{ request -> }
            .get()
        Log.d(LOG_TAG, "InfoMessage: ${re}")
    }
}


class SenderAsyncPost : AsyncTask<String, Void, String>() {
    val LOG_TAG = "TEST_LOG SenderAsync"
    override fun doInBackground(vararg params: String?): String? {
        for(param in params) {
            if(param!=null) {
                sendRequestOverFuel(param)
            }
        }
        return null
    }

    fun sendRequestOverFuel(data: String) {
        Log.d(LOG_TAG, "Data: ${data}")
        val re = Fuel.post("http://37.195.44.14:7878/api/v1/users")
            .header("Content-Type", "application/json")
            .body(data)
            .response{ request -> }
            .get()
        Log.d(LOG_TAG, "InfoMessage: $re")
    }
}

