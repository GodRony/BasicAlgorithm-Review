package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.databinding.ActivityAddRecipeBinding

class AddRecipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityAddRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root) // 레이아웃 설정을 명시적으로 호출


        // 버튼 클릭 리스너 설정
        binding.confirm.setOnClickListener {
            // EditText에서 입력 값 가져오기
            val foodName = binding.foodNameInput.text.toString()
            val kcal = binding.kcalInput.text.toString()
            val ingredients = binding.ingredientsInput.text.toString()
            val recipe = binding.recipeInput.text.toString()

            // 입력 값 검증
            if (foodName.isEmpty() || kcal.isEmpty() || ingredients.isEmpty() || recipe.isEmpty()) {
                Toast.makeText(this, "모든 항목을 입력해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 데이터 전달용 Intent 생성
            val resultIntent = Intent().apply {
                putExtra("foodName", foodName)
                putExtra("kcal", kcal)
                putExtra("ingredients", ingredients)
                putExtra("recipe", recipe)
            }

            setResult(RESULT_OK, resultIntent) // 결과를 반환
            finish() // 현재 화면 종료
        }



        // 롱 클릭 시 액티비티 종료
        binding.confirm.setOnLongClickListener {
            finish()
            true
        }
    }
}