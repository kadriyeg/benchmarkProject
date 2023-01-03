
package com.kadriyeg.benchmarkproject
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.os.SystemClock

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
        for (i in 1..100000) {
            sum += Math.sqrt(i.toDouble())
        }

        // Display the elapsed time in the TextView
        val elapsedTime = SystemClock.elapsedRealtime() - startTime
        textView.text = "Elapsed time: $elapsedTime ms"

        // Return the elapsed time in milliseconds
        return elapsedTime
    }
}


















/*class CpuTestActivity : AppCompatActivity() {
    private lateinit var textView: TextView
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
        var result = 11

        // Perform a large number of calculations in a loop
        for (i in 0 until 100) {
            // Generate two random numbers and perform some calculations on them
            val a = rand.nextInt()
            val b = rand.nextInt()
            result = a * b + a / b
        }

        return result
    }
}*/