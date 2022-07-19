package com.example.advancedcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Activity_algorithms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithms)

        //Class
        val alg = Algorithms()

        //Display
        val calc = findViewById<TextView>(R.id.tvCal)

        //Algorithms
        val silnia = findViewById<TextView>(R.id.tvSilnia)
        val fib = findViewById<TextView>(R.id.tvFib)
        val pier = findViewById<TextView>(R.id.tvPier)
        val log = findViewById<TextView>(R.id.tvLog)
        val sin = findViewById<TextView>(R.id.tvSin)
        val cos = findViewById<TextView>(R.id.tvCos)
        val tan = findViewById<TextView>(R.id.tvTan)
        val ctg = findViewById<TextView>(R.id.tvCtg)
        val cube = findViewById<TextView>(R.id.tvCube)
        val bin = findViewById<TextView>(R.id.tvBin)
        val oct = findViewById<TextView>(R.id.tvOct)
        val hex = findViewById<TextView>(R.id.tvHex)
        val mod = findViewById<TextView>(R.id.tvMod)
        val divOne = findViewById<TextView>(R.id.tvDivideByOne)
        val perfect = findViewById<TextView>(R.id.tvPerfect)
        val e = findViewById<TextView>(R.id.tvE)
        val pi = findViewById<TextView>(R.id.tvPi)


        //Display
        var Result= findViewById<TextView>(R.id.tvResult)
        var Expression = findViewById<TextView>(R.id.tvExpression)


        //Code
        Expression.text = intent.getStringExtra("value")

        //Functions
        fun checkData(): Boolean
        {
            val string = Expression.text.toString()
            if(string.isEmpty())
                return false
            try {
                var x: Double = string.toDouble()
                return true
            }catch(e: Exception)
            {
                Log.d("Exception", " message : " + e.message)
                return false
            }
        }

        //Functions Listeners

        pi.setOnClickListener {
            Result.text = alg.pi()
        }

        e.setOnClickListener {
            Result.text = alg.e()
        }

        perfect.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                x = alg.mod(x)
                val y = x.toInt()

                Expression.text = y.toString()

                Result.text = alg.perfect(y)
            }
        }

        divOne.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                x = alg.divOne(x)
                Result.text = alg.mod(x).toString()
            }
        }

        mod.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                val x = string.toDouble()
                Result.text = alg.mod(x).toString()
            }
        }

        oct.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                x = alg.mod(x)
                val y = x.toInt()

                Expression.text = y.toString()

                Result.text = alg.oct(y)
            }
        }

        hex.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                x = alg.mod(x)
                val y = x.toInt()

                Expression.text = y.toString()

                Result.text = alg.hex(y)
            }
        }

        bin.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                x = alg.mod(x)
                val y = x.toInt()

                Expression.text = y.toString()

                Result.text = alg.bin(y)
            }
        }

        cube.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                val x = string.toDouble()
                val result = alg.powerCube(x)
                Result.text = result.toString()
            }
        }

        cos.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                val result = alg.cosinus(x)
                Result.text = result.toString()
            }
        }

        tan.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                val result = alg.tangens(x)
                Result.text = result.toString()
            }
        }

        ctg.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                val result = alg.cotangens(x)
                Result.text = result.toString()
            }
        }

        sin.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                val result = alg.sinus(x)
                Result.text = result.toString()
            }
        }

        log.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                val x = string.toDouble()
                val result = alg.log(x)
                Result.text = result.toString()
            }
        }

        pier.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                val x = string.toDouble()
                val result = alg.pier(x)
                Result.text = result.toString()
            }
        }

        calc.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        fib.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData())
            {
                var x = string.toDouble()
                x = alg.mod(x)
                var y = x.toInt()

                Expression.text = y.toString()

                y = alg.fibonacci(y)
                Result.text = y.toString()
            }
        }

        silnia.setOnClickListener {
            val string = Expression.text.toString()
            if(checkData()){
                    var x = string.toDouble()
                     x = alg.mod(x)

                    var y = x.toInt()

                    Expression.text = y.toString()

                    y = alg.silnia(y)
                    Result.text = y.toString()
                }
            }
        }

    }