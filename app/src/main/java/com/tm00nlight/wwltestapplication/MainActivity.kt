package com.tm00nlight.wwltestapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onBackPressed() =
        Toast.makeText(this, getString(R.string.back_button_text), Toast.LENGTH_LONG)
            .show()
}