package com.bengavan.timingtools

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator


// Requirements:
//   - set time period (in seconds)
//   - start with button
//   - show countdown (in seconds)
//   - vibrate on finish

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)


        var time_left = 10
        val time_left_txt = findViewById<TextView>(R.id.time_left_textview)
        val start_btn = findViewById<Button>(R.id.start_button)
        start_btn.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_LONG).show()
            thread(start=true) {
                repeat(10) { i ->
                    Thread.sleep(1_000)
                    time_left--
                    runOnUiThread {
                        time_left_txt.setText(time_left.toString() + " seconds")
                    }
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(500,
                        VibrationEffect.DEFAULT_AMPLITUDE))
                }
                else {
                    v.vibrate(500)
                }
            }
        }
    }
}