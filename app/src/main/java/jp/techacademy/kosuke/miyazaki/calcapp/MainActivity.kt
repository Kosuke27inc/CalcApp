package jp.techacademy.kosuke.miyazaki.calcapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText_1)
        editText2 = findViewById(R.id.editText_2)

        findViewById<Button>(R.id.button_1).setOnClickListener { calculate("+") }
        findViewById<Button>(R.id.button_2).setOnClickListener { calculate("-") }
        findViewById<Button>(R.id.button_3).setOnClickListener { calculate("*") }
        findViewById<Button>(R.id.button_4).setOnClickListener { calculate("/") }
    }

    private fun calculate(operator: String) {
        val num1Str = editText1.text.toString()
        val num2Str = editText2.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "数値を入力してください", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = num1Str.toInt()
        val num2 = num2Str.toInt()
        var result = 0

        when (operator) {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "*" -> result = num1 * num2
            "/" -> {
                if (num2 == 0) {
                    Toast.makeText(this, "0で割ることはできません", Toast.LENGTH_SHORT).show()
                    return
                }
                result = num1 / num2
            }
        }

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}