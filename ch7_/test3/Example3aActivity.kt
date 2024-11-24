package com.example.ch7_.test3

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ch7_.R
import com.example.ch7_.databinding.ActivityExample3aBinding

class Example3aActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityExample3aBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btn.setOnClickListener {
            binding.btn.visibility = View.INVISIBLE
            binding.image2.visibility = View.VISIBLE
        }
        // 고차 함수

        binding.image2.setOnClickListener{
            binding.btn.visibility = View.VISIBLE
            binding.image2.visibility = View.INVISIBLE
        }

    }
}