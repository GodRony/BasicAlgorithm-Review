package com.example.ch6.test1

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ch6.R

class Example1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity_example1)

        val name= TextView(this).apply{
            typeface = Typeface.DEFAULT_BOLD
            text = "Hallym University"
        }
        val image = ImageView(this).also {
            it.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.hallym_symbol))
        }

        val address = TextView(this).apply { 
            typeface = Typeface.DEFAULT_BOLD
            text = "한림대학교"
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            addView(name,WRAP_CONTENT, WRAP_CONTENT)
            addView(image,WRAP_CONTENT, WRAP_CONTENT)
            addView(address,WRAP_CONTENT, WRAP_CONTENT)
        }
        setContentView(layout)
    }
}