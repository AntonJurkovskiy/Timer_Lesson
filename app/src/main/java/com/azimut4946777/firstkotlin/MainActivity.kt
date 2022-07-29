package com.azimut4946777.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.azimut4946777.firstkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
     private var timer: CountDownTimer? = null
     private var myTime: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            buttonStart.setOnClickListener {
                if (timer == null) {
                    startTimer(10000)
                } else {

                    startTimer(myTime!!)
                }

            }
            buttonReset.setOnClickListener {
                timer?.cancel()
                timer = null
                binding.apply {
                    textViewTime1.text = "00"
                    textViewTime2.text = "00"
                }

            }
            buttonStrop.setOnClickListener {
                timer?.cancel()



            }

        }


    }

    private fun startTimer(time: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(time, 10) {
            override fun onTick(timeM: Long) {
                myTime = timeM
                binding.textViewTime1.text = (timeM).toString().take(2)
                binding.textViewTime2.text = (timeM).toString().takeLast(2)
            }

            override fun onFinish() {

                binding.textViewStatus.text = "Finish!!!!"
                binding.textViewStatus.visibility = View.VISIBLE
            }
        }.start()
    }




}



