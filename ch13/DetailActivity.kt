package com.example.ch13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent 데이터 확인
        val data = intent.data
        binding.txtView2.text = data.toString() // 전달받은 URL 표시

        binding.btn2.setOnClickListener {
            val data1 = intent.getStringExtra("key1")
            val data2 = intent.getIntExtra("key2", 100)
            binding.txtView2.text = "$data1, $data2"
        }

        binding.btn2.setOnLongClickListener {
            setResult(RESULT_OK, intent)
            intent.putExtra("result", 1000)
            finish()
            true
        }
    }

}