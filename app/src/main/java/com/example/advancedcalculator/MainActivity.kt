package com.example.advancedcalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Numbers
        val Zero = findViewById<TextView>(R.id.tvZero)
        val One = findViewById<TextView>(R.id.tvOne)
        val Two = findViewById<TextView>(R.id.tvTwo)
        val Three = findViewById<TextView>(R.id.tvThree)
        val Four = findViewById<TextView>(R.id.tvFour)
        val Five = findViewById<TextView>(R.id.tvFive)
        val Six = findViewById<TextView>(R.id.tvSix)
        val Seven = findViewById<TextView>(R.id.tvSeven)
        val Eight = findViewById<TextView>(R.id.tvEight)
        val Nine = findViewById<TextView>(R.id.tvNine)

        //Operators
        val Plus = findViewById<TextView>(R.id.tvPlus)
        val Minus = findViewById<TextView>(R.id.tvMinus)
        val Mul = findViewById<TextView>(R.id.tvMul)
        val Divide = findViewById<TextView>(R.id.tvDivide)
        val OpenN = findViewById<TextView>(R.id.tvOpen)
        val CloseN = findViewById<TextView>(R.id.tvClose)
        val Dot = findViewById<TextView>(R.id.tvDot)
        val Clear = findViewById<TextView>(R.id.tvCE)
        val Back = findViewById<ImageView>(R.id.tvBack)
        val Equals = findViewById<TextView>(R.id.tvEquals)

        //Display
        var Result= findViewById<TextView>(R.id.tvResult)
        var Expression = findViewById<TextView>(R.id.tvExpression)
        var Alg = findViewById<TextView>(R.id.tvAlg)


        //Functions Listener
        Alg.setOnClickListener {
            val intent = Intent(this, Activity_algorithms::class.java)
            intent.putExtra("value", Expression.text.toString())
            startActivity(intent)
        }

        Clear.setOnClickListener {
            Result.text = ""
            Expression.text = ""
        }

        Back.setOnClickListener {
            val string = Expression.text.toString()
            if(string.isNotEmpty())
                Expression.text = string.substring(0, string.length-1)
        }

        Equals.setOnClickListener {
            try{
                val expression = ExpressionBuilder(Expression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    Result.text = longResult.toString()
                else
                    Result.text = result.toString()
            }catch(e: Exception)
            {
                Log.d("Exception", " message : " + e.message)
            }
        }

        fun appendOnExpression(string: String, canClear: Boolean)
        {
            if(Result.text.isNotEmpty())
            {
                Expression.text = ""
            }

            if(canClear)
            {
                Result.text = ""
                Expression.append(string)
            }
            else
            {
                Expression.append(Result.text)
                Expression.append(string)
                Result.text = ""
            }
        }

        // Numbers
        One.setOnClickListener { appendOnExpression("1", true) }
        Two.setOnClickListener { appendOnExpression("2", true) }
        Three.setOnClickListener { appendOnExpression("3", true) }
        Four.setOnClickListener { appendOnExpression("4", true) }
        Five.setOnClickListener { appendOnExpression("5", true) }
        Six.setOnClickListener { appendOnExpression("6", true) }
        Seven.setOnClickListener { appendOnExpression("7", true) }
        Eight.setOnClickListener { appendOnExpression("8", true) }
        Nine.setOnClickListener { appendOnExpression("9", true) }
        Zero.setOnClickListener { appendOnExpression("0", true) }

        //Operators
        Plus.setOnClickListener { appendOnExpression("+", true) }
        Minus.setOnClickListener { appendOnExpression("-", true) }
        Mul.setOnClickListener { appendOnExpression("*", true) }
        Divide.setOnClickListener { appendOnExpression("/", true) }
        OpenN.setOnClickListener { appendOnExpression("(", true) }
        CloseN.setOnClickListener { appendOnExpression(")", true) }
        Dot.setOnClickListener { appendOnExpression(".", true) }

    }
}