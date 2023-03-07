package com.tm00nlight.wwltestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onBackPressed() {
        Toast.makeText(this, "Не-а, ты останешься здесь! :)", Toast.LENGTH_LONG)
            .show()
    }
}