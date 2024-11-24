package com.example.ch13.test1

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13.DetailActivity
import com.example.ch13.databinding.ActivityExample1Binding

class Example1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val launcher : ActivityResultLauncher<Intent> =
            registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
                // 콜백 함수 작성
                val resultData = it.data?.getStringExtra("result" )
                binding.txtView.text = "DetailActivity에서 $resultData 전달"

        }
        binding.btn1.setOnClickListener{
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("key1","안녕하세여")
            intent.putExtra("key2", 10)
            launcher.launch(intent)
        }


    }
}