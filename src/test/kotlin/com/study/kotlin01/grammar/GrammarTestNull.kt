package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * nullable변수에서 null을 처리하는 법과 변수간의 동일성을 확인하는 방법
 * ?. null safe operator : 참조연산자를 실행하기 전에 먼저 객체가 null인지 확인부터하고 객체가 null이라면 뒤따라오는 구문을 실행하지 않음 (ex: sample?.lowercase() -> sample이 null일시 lowercase()는 실행하지 않음)
 * ?: elvis operator : 객체가 null이 아니라면 그대로 사용하지만 null이라면 연산자 우측의 객체로 대체됨 (ex: sample?:"default" ->sample이 null일시 "default"값으로 됨)
 * !!. non-null assertion operator : 참조연산자를 사용할때 null 여부를 컴파일시 확인하지 않도록 하여 런타임시 null pointer exception이 나도록 의도적으로 방치하는 연산자
 */
class GrammarTestNull {

    @Test
    fun `null테스트`() {
        var a: String? = null
//        println(a?.uppercase())
//        println(a ?: "default".uppercase())
//        println(a!!.uppercase()) // nullprinterexception실행됨

        a = "Kotlin Exam"
        a?.run {
            println(lowercase())
            println(uppercase())
        }
    }

    @Test
    fun `변수의 동일성 체크`() {

        var a = Product("콜라", 1000)
        var b = Product("콜라", 1000)
        var c = a
        var d = Product("사이다", 1000)

        println(a == b) //내용의 동일성 equals
        println(a === b) //객체의 동일성 hash

        println("---------------")
        println(a == c)
        println(a === c)

        println("---------------")
        println(a == d)
        println(a === d)

    }
    class Product(val name: String, val price: Int) {
        override fun equals(other: Any?): Boolean {
            return if (other is Product) {
                other.name == name && other.price == price
            } else {
                false
            }
        }
    }


}