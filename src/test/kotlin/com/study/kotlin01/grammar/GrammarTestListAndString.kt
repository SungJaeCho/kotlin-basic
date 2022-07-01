package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * List<out T> : 생성시에 넣은 객체를 대체, 추가, 삭제 할수 없음
 * MutableList<T> : 생성시에 넣은 객체를 대체, 추가, 삭제 가능
 */
class GrammarTestListAndString {

    @Test
    fun `리스트문법`() {
        var a = listOf("사과","딸기","배")
        println(a[1])
        for (fruit in a) {
            print("fruit = ${fruit}")
        }
        println()

        var b = mutableListOf(6, 3, 1)
        println(b)

        b.add(4)
        println(b)

        b.add(2, 8)
        println(b)

        b.removeAt(1)
        println(b)

        b.shuffle()
        println(b)

        b.sort()
        println(b)
    }

    @Test
    fun `문자열테스트`() {
        var test1 = "Test.Kotlin.String"
        println(test1.length)
        println(test1.lowercase())
        println(test1.uppercase())

        var test2 = test1.split(".")
        println(test2)

        println(test2.joinToString())
        println(test2.joinToString("-"))

        println(test1.substring(5..10))
    }

    @Test
    fun `문자열반환값확인테스트`() {
        var nullString:String? = null
        var emptyString = ""
        var blankString = " "
        var normalString = "A"

        // null or empty -> true
        println(nullString.isNullOrEmpty())
        println(emptyString.isNullOrEmpty())
        println(blankString.isNullOrEmpty())
        println(normalString.isNullOrEmpty())

        println()
        println(nullString.isNullOrBlank())
        println(emptyString.isNullOrBlank())
        println(blankString.isNullOrBlank())
        println(normalString.isNullOrBlank())
    }

    @Test
    fun `문자열반환값확인테스트2`() {
        var test3 = "kotlin.kt"
        var test4 = "java.java"

        println(test3.startsWith("java"))
        println(test4.startsWith("java"))

        println(test3.endsWith(".kt"))
        println(test4.endsWith(".kt"))

        println(test3.contains("lin"))
        println(test4.contains("lin"))
    }
}