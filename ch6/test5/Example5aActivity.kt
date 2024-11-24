package com.example.ch6.test5

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ch6.databinding.ActivityExample5aBinding

class Example5aActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
       // setContentView(R.layout.activity_example5a)

        val binding = ActivityExample5aBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.visibleBtn1.setOnClickListener{
            binding.targetText.visibility= View.VISIBLE
        }

        binding.hideBtn.setOnClickListener{
            binding.targetText.visibility= View.INVISIBLE
        }
    }
}