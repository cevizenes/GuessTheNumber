package com.example.guessthenumber


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_gameplay.*




class GameplayActivity : AppCompatActivity() {
    private var hak = 5
    private var randomNum =0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        randomNum = (0..101).shuffled().last()

        Log.e("num", randomNum.toString())
        guessButton.setOnClickListener {

            hak-=1
            if(guessText.text.toString().toInt() == randomNum){
                val intent = Intent(this@GameplayActivity,ResultActivity ::class.java)
                intent.putExtra("sonuc",true)
                finish()
                startActivity(intent)

                return@setOnClickListener//bu olay tamamlandığında aşağıdaki kodlar çalışmaz!!
            }

            if(guessText.text.toString().toInt()<randomNum){
                infoText.text = "Arttır"
                hakText.text = "Hak : $hak"
            }
            if(guessText.text.toString().toInt()>randomNum){
                infoText.text = "Azalt"
                hakText.text = "Hak : $hak"
            }

            if(hak == 0){
                val intent = Intent(this@GameplayActivity,ResultActivity::class.java)
                intent.putExtra("sonuc",false)
                finish()
                startActivity(intent)
            }




        }

    }
}