package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test
import java.util.*

class GrammarTest {
    @Test
    fun main() {
        println("hello world")

        var a:Int = 10
        var b: Long = a.toLong()
        println("a: $a b: $b")

        var intArr = arrayOf(1, 2, 3, 4, 5)
        var nullArr = arrayOfNulls<Int>(5)
        var intArr2 : Array<Int> = Array(3) {0}
        var intArr3 : Array<Int> = Array(3) {i->i}
        println(Arrays.toString(intArr2))
        println(Arrays.toString(intArr3))
    }
}