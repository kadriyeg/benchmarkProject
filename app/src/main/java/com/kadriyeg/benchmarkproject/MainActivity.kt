package com.kadriyeg.benchmarkproject


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.TextView
import android.os.AsyncTask
import kotlin.system.measureNanoTime

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.cpuTest)

        // Start the stress test in a background thread
        StressTestTask().execute()
    }

    inner class StressTestTask : AsyncTask<Void, Void, Long>() {
        override fun doInBackground(vararg params: Void?): Long {
            // Perform the stress test
            return measureNanoTime {
                var i = 0
                while (i < 10000) {
                    i++
                }
            }
        }

        override fun onPostExecute(result: Long?) {
            // Update the UI with the result of the stress test
            textView.text = result.toString()
        }
    }
}
