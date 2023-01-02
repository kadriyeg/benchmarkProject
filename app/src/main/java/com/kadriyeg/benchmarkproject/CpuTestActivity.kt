
package com.kadriyeg.benchmarkproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import java.util.Random

class CpuTestActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Perform the stress test
        val result = performStressTest()
        // Update the TextView with the results
        val textView = findViewById<TextView>(R.id.cpuAct)

        // Display the results in the TextView
        textView.text = "CPU stress test results: $result"
    }
    fun performStressTest(): Int {
        val rand = Random()
        var result = 0

        // Perform a large number of calculations in a loop
        for (i in 0 until 100) {
            // Generate two random numbers and perform some calculations on them
            val a = rand.nextInt()
            val b = rand.nextInt()
            result = a * b + a / b
        }

        return result
    }
}