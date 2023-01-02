package com.kadriyeg.benchmarkproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.AsyncTask
import android.widget.TextView
import kotlin.system.measureNanoTime

class GpuTestActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gpu_test)

        textView = findViewById(R.id.gpuAct)

        // Start the stress test in a background thread
        StressTestTask().execute()
    }

    inner class StressTestTask : AsyncTask<Void, Void, Long>() {
        override fun doInBackground(vararg params: Void?): Long {
            // Perform the stress test
            return measureNanoTime {
                val bitmap = Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888)
                val canvas = Canvas(bitmap)

                var i = 0
                while (i < 100) {
                    // Draw a complex graphic on the canvas
                    drawGraphic(canvas)
                    i++
                }
            }
        }

        override fun onPostExecute(result: Long?) {
            // Update the UI with the result of the stress test
            textView.text = result.toString()
        }
    }

    private fun drawGraphic(canvas: Canvas) {
        // TODO: Implement a complex graphic drawing operation
    }
}
