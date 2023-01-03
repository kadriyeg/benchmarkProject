package com.kadriyeg.benchmarkproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.TextView
import kotlin.random.Random

class StringBTestActivity : AppCompatActivity() {

    private val TAG = "StringTestActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string_btest)

        val startTime = SystemClock.elapsedRealtime()

        // Generate a random string of length 100000
        val testString = generateRandomString(10)

        // Test string concatenation
        val stringConcatResult = testStringConcat(testString)

        // Test string interpolation
        val stringInterpResult = testStringInterp(testString)

        val endTime = SystemClock.elapsedRealtime()
        val totalTime = endTime - startTime

        // Get a reference to the TextViews
        val stringConcatResultTextView = findViewById<TextView>(R.id.text_view_string_concat_result)
        val stringInterpResultTextView = findViewById<TextView>(R.id.text_view_string_interp_result)
        val totalTimeTextView = findViewById<TextView>(R.id.text_view_total_time)

        // Update the text of the TextViews
        stringConcatResultTextView.text = stringConcatResult
        stringInterpResultTextView.text = "heloooooo $stringInterpResult"
        totalTimeTextView.text = " total timeeee $totalTime ms"
    }


    private fun generateRandomString(length: Int): String {
        val stringBuilder = StringBuilder(length)
        for (i in 0 until length) {
            stringBuilder.append(Random.nextInt(0, 10).toString())
        }
        return stringBuilder.toString()
    }

    private fun testStringConcat(testString: String): String {
        var result = ""
        for (i in 0 until 10) {
            result += testString
        }
        return result
    }

    private fun testStringInterp(testString: String): String {
        var result = ""
        for (i in 0 until 10) {
            result = "$result$testString"
        }
        return result
    }
}
