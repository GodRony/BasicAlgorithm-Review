package com.example.ch9.test3

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ch9.R

class Example3Activity : AppCompatActivity() {
    var keyDownTime = 0L // 백버튼 누른 시점을 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_example3)

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            // 처음 백 버튼을 누르거나 누른지 3초가 지났을 때
            if(System.currentTimeMillis() - keyDownTime > 3000){
                Toast.makeText(this,"종료하려면 한 번 더 누르세요",Toast.LENGTH_LONG).show()
                keyDownTime = System.currentTimeMillis()
                return true
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}