package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test
import java.util.Arrays.asList

class GrammarTest04 {

    @Test
    fun main() {
        val a = arrayOf(1,2,3)
        val list = asList(-1, 0, *a, 4)
        println(list)

        val string = "Hello" add "World"
        println(string)

        var arr = IntArray(10) {i-> 0}
        for (i in arr) {
            println("$i")
        }

    }
    infix fun String.add(other:String): String {
        return this + other
    }
}
