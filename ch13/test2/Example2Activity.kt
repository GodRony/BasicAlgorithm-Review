package com.example.ch13.test2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13.databinding.ActivityExample2Binding

class Example2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btn3.setOnClickListener {
            val intent = Intent().apply {
                action = "ACTION_VIEW"
               // action = "ACTION_EDIT"
                data = Uri.parse("http://www.hallym.ac.kr")
                addCategory("CATEGORY_TEST")
         //       addCategory("android.intent.category.HOME")
            }

            try{
                startActivity(intent)

            }catch (e : Exception){
                Toast.makeText(this,"인텐트로 실행할 수 있는 액티비티가 없습니다."
                ,Toast.LENGTH_LONG).show()
            }
        }

        binding.btn4.setOnClickListener {
            // 지도 호출
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.setPackage("com.google.android.apps.maps")
//
//            val packageInfo = packageManager.getPackageInfo("com.google.android.apps.maps",0)
//            Log.d("mop",packageInfo.versionName.toString())
//
//            if(intent.resolveActivity(packageManager) != null){
//                startActivity(intent)
//            }else{
//                Toast.makeText(this,"구글 지도가 설치 되어있지 않습니다.",
//                    Toast.LENGTH_LONG).show()
//            }

            // 갤러리 호출
//            val intent = Intent().apply {
////                action = Intent.ACTION_GET_CONTENT
//                action = Intent.ACTION_PICK
//                type = "image/*"
//            }
//            startActivity(intent)

            // 전화걸기 화면 호출
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = Uri.parse("tel:033-248-2334")
            startActivity(intent)
        }



    }
}