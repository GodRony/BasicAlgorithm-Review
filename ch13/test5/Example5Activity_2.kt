package com.example.ch13.test5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13.databinding.ActivityExample52Binding
import kotlin.system.measureTimeMillis

class Example5Activity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample52Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var sum = 0L

        binding.btn.setOnClickListener {
            var time = measureTimeMillis {
                for(i in 1 .. 20000){
                    sum += i
                }
            }
            binding.textView.text = "계산 시간: ${time / 1000f} 초"
        }

        /*        binding.btn.setOnClickListener {
                    val channel = Channel<Long>()
                    val backgroundScope = CoroutineScope(Dispatchers.Default + Job())

                    backgroundScope.launch {
                        var sum = 0L
                        var time = measureTimeMillis {
                            for(i in 1 .. 2000000000){
                                sum += i
                            }
                        }
                        channel.send(time)
                    }
                    GlobalScope.launch(Dispatchers.Main){
                        channel.consume {
                            binding.textView.text
                        }
                    }
                }*/
    }
}