package com.example.guessthenumber

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getBooleanExtra("sonuc",false)

        if(result){
            imageView.setImageResource(R.drawable.smile)
            resultText.text = "KAZANDINIZ"
        }
        else{
            imageView.setImageResource(R.drawable.sad)
            resultText.text = "KAYBETTİNİZ"
        }

        repeatGame.setOnClickListener {
            val intent = Intent(this@ResultActivity,GameplayActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}