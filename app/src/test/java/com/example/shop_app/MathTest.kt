package com.example.shop_app

import org.junit.Assert
import org.junit.Test

class MathTest {
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }

    @Test
    fun incrementTest() {
        var i = 1
        i += 1
        Assert.assertEquals(2, i)
    }

    @Test
    fun divideTest() {
        var i = 4
        i /= 2
        Assert.assertEquals(2, i)
    }

    @Test
    fun multiplyTest() {
        var i = 1
        i *= 2
        Assert.assertEquals(2, i)
    }

    @Test
    fun substractionTest() {
        var i = 2
        i -= 1
        Assert.assertEquals(1, 1)
    }
}