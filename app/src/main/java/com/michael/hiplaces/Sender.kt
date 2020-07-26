package com.michael.hiplaces

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
/*

class Sender(val data: IBoxedData) {
    val LOG_TAG = "Sender"
    /*
    * send data to the server
    **/
    private fun sentRequest() {
        Log.d(LOG_TAG, "fun sentRequest");
        val jsonSignInBoxedData = processData()
        sendHttp(jsonSignInBoxedData)
        Log.d(LOG_TAG, "jsonBox: ${jsonSignInBoxedData}")
    }

    fun sendHttp(jsonSignInBoxedData: String) {
        Log.d(LOG_TAG, "sendHttp")
        val url = URL("http://37.195.44.14/")
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            val wr = OutputStreamWriter(outputStream)
            wr.write(jsonSignInBoxedData)
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
    }
}
*/