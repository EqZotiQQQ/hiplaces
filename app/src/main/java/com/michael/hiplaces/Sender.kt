package com.michael.hiplaces

import android.os.AsyncTask
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import java.io.FileNotFoundException
import java.lang.Exception


class Sender(val data: String, val type: String) {
    val LOG_TAG = "TEST_LOG Sender!!"
    fun send() {
        if(type == "signin") {
            val worker = SenderAsyncLog()
            worker.execute(data)
        } else if (type == "signup") {
            val worker = SenderAsyncPost()
            worker.execute(data)
        } else {
            Log.d(LOG_TAG, "Wrong http method")
        }
    }
}

class SenderAsyncLog : AsyncTask<String, Void, String>() {
    val LOG_TAG = "TEST_LOG SenderAsync"

    override fun doInBackground(vararg params: String?): String? {
        for(param in params) {
            if(param!=null) {
                try {
                    sendRequestOverFuel(param)
                } catch (e: FileNotFoundException) {
                    Log.d(LOG_TAG, "File not found exception occupied")
                    e.printStackTrace()
                } catch (e: Exception) {
                    Log.d(LOG_TAG, "File not found exception occupied")
                    e.printStackTrace()
                }
            }
        }
        return null
    }

    fun sendRequestOverFuel(data: String): String? {
        Log.d(LOG_TAG, "Data: ${data}")
        var req: String = ""
        val re = Fuel.post("http://37.195.44.14:7878/api/v1/users/login")
            .header("Content-Type", "application/json")
            .body(data)
            .also { Log.d(LOG_TAG, "inside sendRequest it: ${it}") }
            .response{request -> ; req = request.toString(); Log.d(LOG_TAG, "${request.component1().toString()} ${request.component2().toString()} ${request.get().toString()} ${request} ${request}")}
            .get()
        Log.d(LOG_TAG, ": ehm?  $re")
        return null
    }
}


class SenderAsyncPost : AsyncTask<String, Void, String>() {
    val LOG_TAG = "TEST_LOG SenderAsync"

    override fun doInBackground(vararg params: String?): String? {
        for(param in params) {
            if(param!=null) {
                try {
                    sendRequestOverFuel(param)
                } catch (e: FileNotFoundException) {
                    Log.d(LOG_TAG, "File not found exception occupied")
                    e.printStackTrace()
                } catch (e: Exception) {
                    Log.d(LOG_TAG, "File not found exception occupied")
                    e.printStackTrace()
                }
            }
        }
        return null
    }

    fun sendRequestOverFuel(data: String): String? {
        Log.d(LOG_TAG, "Data: ${data}")
        Fuel.post("http://37.195.44.14:7878/api/v1/users")
            .header("Content-Type", "application/json")
            .body(data)
            .also { Log.d(LOG_TAG, "inside sendRequest it: ${it}") }
            .response{ request -> ; Log.d(LOG_TAG, "request: ${request}") }
        return null
    }
}

