
package com.kadriyeg.benchmarkproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import java.util.Random

class PerformanceTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_performance_test)

        val textView = findViewById<TextView>(R.id.cpuAct)

        // Run the benchmark and display the elapsed time in the TextView
        val elapsedTime = runBenchmark(textView)
    }

    fun runBenchmark(textView: TextView): Long {
        // Start the benchmark
        val startTime = SystemClock.elapsedRealtime()

        // Perform some computation
        var sum = 0.0
        for (i in 1..1000000) {
            sum += Math.sqrt(i.toDouble())
        }

        // Display the elapsed time in the TextView
        val elapsedTime = SystemClock.elapsedRealtime() - startTime
        textView.text = "Elapsed time: $elapsedTime ms"

        // Return the elapsed time in milliseconds
        return elapsedTime
    }
}
