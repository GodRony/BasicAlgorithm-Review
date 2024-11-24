package com.example.ch13.test3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13.databinding.ActivityExample3Binding

class Example3Activity : AppCompatActivity() {
    var count = 0
    lateinit var binding : ActivityExample3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExample3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countBtn.setOnClickListener {
            count++
            binding.resultTxt.text = "$count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count",count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val savedCount = savedInstanceState.getInt("count")
        binding.resultTxt.text = "$savedCount"
        count = savedCount

    //      Log.d("mop",count.toString())
    }

}