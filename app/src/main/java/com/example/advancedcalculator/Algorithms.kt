package com.example.advancedcalculator

import android.util.Log.e

class Algorithms {
    fun silnia(x: Int): Int
    {
        if(x <= 1)
            return 1
        return (silnia(x-1) * x)
    }

    fun fibonacci(x: Int): Int
    {
        if(x <= 0)
            return 0
        if(x == 1)
            return 1

        var val1 = 0
        var val2 = 1
        var sum = val1 + val2
        var i = 2

        while(i<=x)
        {
            sum = val1 + val2
            val1 = val2
            val2 = sum
            i++
        }

        return sum
    }

    fun pier(x: Double): Double
    {
        return Math.sqrt(x)
    }

    fun log(x: Double): Double
    {
        return Math.log(x)
    }

    fun sinus(x: Double): Double
    {
        return Math.sin(x)
    }

    fun cosinus(x: Double): Double
    {
        return Math.cos(x)
    }

    fun tangens(x: Double): Double
    {
        return Math.tan(x)
    }

    fun cotangens(x: Double): Double
    {
        return (1/Math.tan(x))
    }

    fun powerCube(x: Double): Double
    {
        return Math.pow(x, 3.0)
    }

    fun bin(x: Int): String
    {
        var y = x
        var string: StringBuilder = StringBuilder()

        do
        {
            var znak: Char = '1'
            if(y%2 == 0)
                znak = '0'

            string.append(znak.toString())

            y = y/2

        }while(y > 0)

        string.reverse()

        return string.toString()
    }

    fun oct(x: Int): String
    {
        val items = listOf<Char>('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        var string: StringBuilder = StringBuilder()

        var y = x
        do{
            var znak: Char = items.get(y%8)
            string.append(znak.toString())
            y = y/8
        }while(y > 0)

        string.reverse()

        return string.toString()
    }

    fun hex(x: Int): String
    {
        val items = listOf<Char>('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
        var string: StringBuilder = StringBuilder()

        var y = x
        do{
            var znak: Char = items.get(y%16)
            string.append(znak.toString())
            y = y/16
        }while(y > 0)

        string.reverse()

        return string.toString()
    }

    fun mod(x: Double): Double
    {
        return Math.abs(x)
    }

    fun divOne(x: Double): Double
    {
        return 1/x
    }

    fun perfect(x: Int): String
    {
        var y = Math.floor(Math.sqrt(x.toDouble()))
        var z = 1
        var i = 2

        while(i <= y)
        {
            if(x%i == 0)
                z += i + x/i
            i++
        }

        if(x == (y*y).toInt())
           z -= y.toInt()

        if(x == z)
            return "TRUE"
        else
            return "FALSE"
    }

    fun e(): String
    {
        return Math.E.toString()
    }

    fun pi(): String
    {
        return Math.PI.toString()
    }
}