package com.example.dlstools

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_money_caluculation_actiivty.*
import kotlin.math.roundToInt


class MoneyCalculationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_caluculation_actiivty)

        btn_caluculate.setOnClickListener {
            caluculatePercentage(et_entered_amt)
        }

        btn_go_back_money_caluculation.setOnClickListener {
            finish()
        }


    }

    @SuppressLint("SetTextI18n")
    fun caluculatePercentage(etAmt: EditText) {
        if (etAmt.text.toString() != "") {
            val amount = etAmt.text.toString().toDouble()
            tv_tax.text =
                resources.getString(R.string.ruppe) + (amount / 100.0f * 20).roundToInt()
            tv_wealth.text =
                resources.getString(R.string.ruppe) + (amount / 100.0f * 10).roundToInt()
            tv_charity.text =
                resources.getString(R.string.ruppe) + (amount / 100.0f * 10).roundToInt()
            tv_general.text =
                resources.getString(R.string.ruppe) + (amount / 100.0f * 30).roundToInt()
            tv_operational.text =
                resources.getString(R.string.ruppe) + (amount / 100.0f * 30).roundToInt()


        } else {
            Toast.makeText(applicationContext, "Amount cannot be empty", Toast.LENGTH_SHORT)
                .show()
            tv_tax.text = getString(R.string.ruppe) + 0
            tv_general.text = getString(R.string.ruppe) + 0
            tv_charity.text = getString(R.string.ruppe) + 0
            tv_wealth.text = getString(R.string.ruppe) + 0
            tv_operational.text = getString(R.string.ruppe) + 0
        }
    }

}