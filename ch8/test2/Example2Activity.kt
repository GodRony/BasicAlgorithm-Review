package com.example.ch8.test2

import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat


import androidx.core.view.WindowInsetsCompat
import com.example.ch8.R
import com.example.ch8.databinding.ActivityExample2Binding

class Example2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityExample2Binding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
   //     binding.btnView.setOnClickListener(this)
   //         binding.checkView.setOnCheckedChangeListener(MyHnadler())
//          binding.checkView.setOnCheckedChangeListener(object  : CompoundButton.OnCheckedChangeListener {
//              override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//                  Log.d("kim", "체크 박스 클릭!... $isChecked")
//              }})
        binding.checkView.setOnCheckedChangeListener{ buttonView, isChecked -> Log.d("kim",
            "체크 박스 클릭.. $isChecked")}
    }

}

class MyHnadler : CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Log.d("kim", "체크 박스 클릭.. $isChecked")
    }
}
