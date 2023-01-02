package com.kadriyeg.benchmarkproject


import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.welcomeText)
        textView = findViewById(R.id.creatorText)


        val cpuButton = findViewById<Button>(R.id.cpuBtn)
        cpuButton.setOnClickListener {
            val intent = Intent(this, CpuTestActivity::class.java)
            startActivity(intent)
        }

        val gpuButton = findViewById<Button>(R.id.gpuBtn)
        gpuButton.setOnClickListener {
            val intent = Intent(this, GpuTestActivity::class.java)
            startActivity(intent)
        }

        val stringButton = findViewById<Button>(R.id.stringBtn)
        stringButton.setOnClickListener {
            val intent = Intent(this, StringBTestActivity::class.java)
            startActivity(intent)
        }

    }
}