package com.example.ch8.test1

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ch8.R

class Example1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_example1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action){
            MotionEvent.ACTION_DOWN -> Log.d("kim","touch down x:${event.x}, y:${event.y} ")
            MotionEvent.ACTION_UP -> Log.d("kim","touch up rawX:${event.rawX}, rawY:${event.rawY}")
        }
        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode : Int, event : KeyEvent?) : Boolean{
        when (keyCode){
            KeyEvent.KEYCODE_BACK -> Log.d("kim","back button")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("kim","volume up")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("kim","volume down")
        }
        return super.onKeyDown(keyCode, event)
    }
}