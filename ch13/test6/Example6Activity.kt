package com.example.ch13.test6

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13.databinding.ActivityExample6Binding

class Example6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val reqLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            // 사후 처리 코드 작성
        }

        binding.addBtn.setOnClickListener{
            val intent = Intent(this,AddActivity::class.java)
            reqLauncher.launch(intent)
        }
    }
}