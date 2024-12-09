package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // 레이아웃 설정을 명시적으로 호출

        val launcher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            //콜백 함수 내용 작성
            val resultData = it.data?.getIntExtra("result",0)
            binding.recommendTxtContent.text = "test용 $resultData 전달받음"
        }
        binding.recipeAdd.setOnClickListener {
            val intent = Intent(this,AddRecipe::class.java)
            intent.putExtra("key1","안녕하세요")
            intent.putExtra("key2",10)
            launcher.launch(intent)
        }
        binding.viewRecipe.setOnClickListener {
            val intent = Intent(this,AllRecipes::class.java)
            launcher.launch(intent)
        }

    }
}
