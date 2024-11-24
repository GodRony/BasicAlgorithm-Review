package com.example.ch13.test6

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DatePickerDialog(this,{view,year,month,dayOfMonth ->
           binding.dateTxt.text = "$year 년 ${month + 1} 월 $dayOfMonth 일"

            val pickedDate = "($year${month+1} / $dayOfMonth)"
            intent.putExtra("date",pickedDate)
        }, 2024,11,13).show()

        binding.saveBtn.setOnClickListener{
            intent.putExtra("result",binding.editTxt.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}