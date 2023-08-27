package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi_calculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener {
            calculateBMI()
        }
    }


    fun calculateBMI(){
        val weight=binding.weightvalue.text.toString().toFloatOrNull()
        val height=binding.heightvalue.text.toString().toFloatOrNull()

        if (weight !=null && height !=null){
            val bmi=weight/(height/100).pow(2)
            val bmiResult= String.format("%.2f",bmi)

            val bmicategory=when{
                bmi < 18.5 -> "Under Weight"
                bmi < 25 -> "Normal Weight"
                bmi < 30 -> "Over Weight"
                else -> "Obese"
            }
            binding.result.text="BMI:$bmiResult\nCategory: $bmicategory"
        }
         else
            binding.result.text= "Its invalid! Kindly check your Details"

    }
}