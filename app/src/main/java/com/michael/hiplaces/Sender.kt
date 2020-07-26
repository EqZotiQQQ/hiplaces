package com.michael.hiplaces

import android.os.AsyncTask
import android.util.Log
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL


class Sender(val data: String) {

}

class SenderAsync : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg params: Void?): Void {
        TODO("Not yet implemented")
    }

}
