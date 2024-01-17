package com.rishabh.antinotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rishabh.antinotest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val numberOne=binding.txtNumber1.text.toString()
            val numberTwo=binding.txtNumber2.text.toString()
            if (checkStatus(numberOne,numberTwo)){
                addNumber(numberOne,numberTwo)
            }
        }

    }
    private fun addNumber(numberOne: String, numberTwo: String){
        val result=numberOne.toFloat()+numberTwo.toFloat()
        binding.txtResult.text=result.toString()
    }

    private fun checkStatus(numberOne: String, numberTwo: String): Boolean {
        return if (numberOne.isEmpty() && numberTwo.isEmpty()) {
            Toast.makeText(this@MainActivity, "Please Enter Number", Toast.LENGTH_SHORT).show()
            false
        } else if (numberOne.isNotEmpty() && numberTwo.isEmpty()) {
            Toast.makeText(this@MainActivity, "Please Enter Number Two", Toast.LENGTH_SHORT).show()
            false
        } else if (numberOne.isEmpty() && numberTwo.isNotEmpty()) {
            Toast.makeText(this@MainActivity, "Please Enter Number One", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }
}