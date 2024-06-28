package com.example.weatherappvolley

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    val apiKey = "b2fbcb88a4da04b923fdbc90b4e07481"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.searchButton)
        button.setOnClickListener {
            val fullURL = "http://api.openweathermap.org/data/2.5/weather?q=Landon,uk&APPID=b2fbcb88a4da04b923fdbc90b4e07481"
            val queue = Volley.newRequestQueue(this)
            val stringRequest = StringRequest(
                Request.Method.GET, fullURL,{response ->
                    println(response.toString())
                },{
                    println(it.message)
                }
            )
            queue.add(stringRequest)
        }
    }
    private fun getWeather() {
        val searchInput = findViewById<EditText>(R.id.searchInput)
        try {
            if (searchInput.text.isNotEmpty()) {
                val fullURL = "http://api.openweathermap.org/data/2.5/weather?q=${searchInput.text},uk&APPID=b2fbcb88a4da04b923fdbc90b4e07481"
                val queue = Volley.newRequestQueue(this)
                val stringRequest = StringRequest(
                  Request.Method.POST, fullURL,{response ->
                      println(response.toString())
                  },{
                      println(it.message)
                  }
              )
                queue.add(stringRequest)

            }
        }catch (err: Exception) {

        }
    }

}