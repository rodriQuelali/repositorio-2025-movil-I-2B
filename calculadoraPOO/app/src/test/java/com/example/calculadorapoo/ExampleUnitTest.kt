package com.example.calculadorapoo

import com.example.calculadorapoo.data.Calculadora
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val cal = Calculadora()
        assertEquals("7.5", cal.suma("5.0","2.5"))
    }
}