package jp.techacademy.kosuke.miyazaki.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val resultTextView: TextView = findViewById(R.id.resultTextView)

        val result = intent.getIntExtra("result", 0)

        resultTextView.text = result.toString()
    }
}