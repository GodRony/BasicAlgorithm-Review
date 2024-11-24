package com.example.ch13.test4

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13.databinding.ActivityExample4Binding

class Example4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityExample4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        binding.showBtn.setOnClickListener {
            binding.edtTxt.requestFocus()
            manager.showSoftInput(binding.edtTxt,InputMethodManager.SHOW_IMPLICIT)
        }
        binding.hideBtn.setOnClickListener {
            manager.hideSoftInputFromWindow(currentFocus?.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS)
        }

    }
}