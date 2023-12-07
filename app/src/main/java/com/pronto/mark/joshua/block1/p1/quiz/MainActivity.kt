package com.pronto.mark.joshua.block1.p1.quiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonDiv: Button
    private lateinit var editTextN1: EditText
    private lateinit var editTextN2: EditText
    private lateinit var textView: TextView

    private var num1 = 0
    private var num2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAdd = findViewById(R.id.btn_add)
        buttonSub = findViewById(R.id.btn_sub)
        buttonMul = findViewById(R.id.btn_mul)
        buttonDiv = findViewById(R.id.btn_div)

        editTextN1 = findViewById(R.id.number1)
        editTextN2 = findViewById(R.id.number2)
        textView = findViewById(R.id.answer)

        buttonAdd.setOnClickListener { handleClick(it) }
        buttonSub.setOnClickListener { handleClick(it) }
        buttonMul.setOnClickListener { handleClick(it) }
        buttonDiv.setOnClickListener { handleClick(it) }
    }

    private fun getIntFromEditText(editText: EditText): Int {
        if (editText.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show()
            return 0
        }
        return editText.text.toString().toInt()
    }

    private fun handleClick(view: View) {
        num1 = getIntFromEditText(editTextN1)
        num2 = getIntFromEditText(editTextN2)

        when (view.id) {
            R.id.btn_add -> textView.text = "Answer = ${num1 + num2}"
            R.id.btn_sub -> textView.text = "Answer = ${num1 - num2}"
            R.id.btn_mul -> textView.text = "Answer = ${num1 * num2}"
            R.id.btn_div -> textView.text = "Answer = ${num1.toFloat() / num2.toFloat()}"
        }
    }
}