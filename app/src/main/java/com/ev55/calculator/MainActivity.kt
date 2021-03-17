package com.ev55.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        one.setOnClickListener { pokaz("1", true) }
        two.setOnClickListener { pokaz("2", true) }
        three.setOnClickListener { pokaz("3", true) }
        four.setOnClickListener { pokaz("4", true) }
        five.setOnClickListener { pokaz("5", true) }
        six.setOnClickListener { pokaz("6", true) }
        seven.setOnClickListener { pokaz("7", true) }
        eight.setOnClickListener { pokaz("8", true) }
        nine.setOnClickListener { pokaz("9", true) }
        zero.setOnClickListener { pokaz("0", true) }
        zap.setOnClickListener { pokaz(".", true) }



        pls.setOnClickListener { pokaz("+", false) }
        min.setOnClickListener { pokaz("-", false) }
        tv_ymn.setOnClickListener { pokaz("*", false) }
        tv_raz.setOnClickListener { pokaz("/", false) }
        tv_skobka1.setOnClickListener { pokaz("(", false) }
        skobka2.setOnClickListener { pokaz(")", false) }


        back.setOnClickListener {
            val stroka = ex.text.toString()

            if (stroka.isNotEmpty()) {
                ex.text = stroka.substring(0, stroka.length - 1)
            }
            result.text = ""
        }

        tv_ac.setOnClickListener {
            result.text = ""
            ex.text = ""
        }



        ok.setOnClickListener {
            try {
                val expression = ExpressionBuilder(ex.text.toString()).build()
                val resultt = expression.evaluate()
                val longResult = resultt.toLong()
                if (resultt == longResult.toDouble())
                    result.text = longResult.toString()
                else
                    result.text = resultt.toString()
            }
            catch (e: Exception)
            {
            Log.d("123", "123"+e.message)
            }
        }
    }
    fun pokaz(stroka:String, ochistka:Boolean) {
        if (result.text.isNotEmpty()){
            ex.text = " "
        }
        if (ochistka)
        {
            result.text = ""
            ex.append(stroka)
        }
        else
        {
            ex.append(result.text)
            ex.append(stroka)
            result.text = ""
        }
    }
}