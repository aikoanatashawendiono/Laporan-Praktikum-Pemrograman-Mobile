package com.example.kalkulator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCost = findViewById<EditText>(R.id.etCost)
        val rgTipOptions = findViewById<RadioGroup>(R.id.rgTipOptions)
        val switchRoundUp = findViewById<Switch>(R.id.switchRoundUp)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val cost = etCost.text.toString().toDoubleOrNull()

            if (cost == null || cost == 0.0) {
                tvResult.text = "Tip Amount: $0.00"
                return@setOnClickListener
            }

            val tipPercent = when (rgTipOptions.checkedRadioButtonId) {
                R.id.rbAmazing -> 0.20
                R.id.rbGood -> 0.18
                else -> 0.15
            }

            var tip = cost * tipPercent
            if (switchRoundUp.isChecked) {
                tip = ceil(tip)
            }

            val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
            tvResult.text = "Tip Amount: $formattedTip"
        }
    }
}
