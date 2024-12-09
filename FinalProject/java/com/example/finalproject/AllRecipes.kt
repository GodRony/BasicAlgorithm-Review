package com.example.finalproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.example.finalproject.databinding.ActivityAllRecipesBinding
import org.json.JSONArray
import org.json.JSONObject

class AllRecipes : AppCompatActivity() {

    private lateinit var binding: ActivityAllRecipesBinding

    // 레시피 저장 함수
    private fun saveRecipe(foodName: String, kcal: String, ingredients: String, recipe: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("recipes", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // 기존 레시피 목록 불러오기
        val existingRecipes = sharedPreferences.getString("recipe_list", "[]")
        val jsonArray = JSONArray(existingRecipes)

        // 새 레시피를 JSON 객체로 추가
        val recipeJson = JSONObject().apply {
            put("foodName", foodName)
            put("kcal", kcal)
            put("ingredients", ingredients)
            put("recipe", recipe)
        }

        jsonArray.put(recipeJson)

        // 업데이트된 JSON 배열을 저장
        editor.putString("recipe_list", jsonArray.toString())
        editor.apply()
    }

    // 저장된 레시피 불러오기
    private fun loadRecipes() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("recipes", Context.MODE_PRIVATE)
        val recipesString = sharedPreferences.getString("recipe_list", "[]")
        val jsonArray = JSONArray(recipesString)

        for (i in 0 until jsonArray.length()) {
            val recipeJson = jsonArray.getJSONObject(i)
            val foodName = recipeJson.getString("foodName")
            val kcal = recipeJson.getString("kcal")
            val ingredients = recipeJson.getString("ingredients")
            val recipe = recipeJson.getString("recipe")

            addRecipeToGrid(foodName, kcal, ingredients, recipe)
        }
    }

    // GridLayout에 레시피 추가 함수
    private fun addRecipeToGrid(foodName: String?, kcal: String?, ingredients: String?, recipe: String?) {
        val txtView = TextView(this).apply {
            text = "$foodName \nkcal: $kcal  재료: $ingredients \n레시피: $recipe\n"
            textSize = 15f
            setPadding(15)
        }

        // GridLayout에 현재 자식 뷰의 개수를 기준으로 행을 설정
        val row = binding.gridLayout.childCount
        val rowSpec = GridLayout.spec(row)  // 현재 자식 수에 따라 행 지정
        val columnSpec = GridLayout.spec(0) // 모든 항목을 0번째 열에 추가

        txtView.layoutParams = GridLayout.LayoutParams(rowSpec, columnSpec).apply {
            width = GridLayout.LayoutParams.MATCH_PARENT
            height = GridLayout.LayoutParams.WRAP_CONTENT
            setMargins(10, 10, 10, 10) // 마진 추가 (선택 사항)
        }

        binding.gridLayout.addView(txtView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 레이아웃 바인딩 초기화
        binding = ActivityAllRecipesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 저장된 레시피 불러오기
        loadRecipes()

        val launcher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val foodName = it.data?.getStringExtra("foodName")
            val kcal = it.data?.getStringExtra("kcal")
            val ingredients = it.data?.getStringExtra("ingredients")
            val recipe = it.data?.getStringExtra("recipe")

            if (foodName != null && kcal != null && ingredients != null && recipe != null) {
                // GridLayout에 레시피 추가
                addRecipeToGrid(foodName, kcal, ingredients, recipe)

                // SharedPreferences에 레시피 저장
                saveRecipe(foodName, kcal, ingredients, recipe)
            }
        }

        // 레시피 추가 버튼 리스너
        binding.recipeAdd.setOnClickListener {
            val intent = Intent(this, AddRecipe::class.java)
            launcher.launch(intent)
        }

        // 확인 버튼 리스너
        binding.confirm.setOnClickListener {
            finish()
        }
    }
}
