package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {
    private suspend fun changeLights(red:Button, yellow:Button, green:Button)
    {
        red.setBackgroundColor(Color.RED)
        delay(1000)
        red.setBackgroundColor(Color.BLACK)
        yellow.setBackgroundColor(Color.YELLOW)
        delay(1000)
        yellow.setBackgroundColor(Color.BLACK)
        green.setBackgroundColor(Color.GREEN)
        delay(1000)
        green.setBackgroundColor(Color.BLACK)
        yellow.setBackgroundColor(Color.YELLOW)
        delay(1000)
        yellow.setBackgroundColor(Color.BLACK)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val redButton = findViewById<Button>(R.id.RedButton)
        val yellowButton = findViewById<Button>(R.id.YellowButton)
        val greenButton = findViewById<Button>(R.id.GreenButton)
        var isRunning = true
        lifecycleScope.launch {
            while (isRunning) {
                changeLights(redButton,yellowButton,greenButton)
            }
        }
    }
}