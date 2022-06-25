package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTest01 {

    @Test
    fun main() {
        doWhen(1)
        doWhen("Me")
        doWhen(12L)
        doWhen(3.12312)
        doWhen("Kotlin")
    }

    fun doWhen(a: Any) {
        var result = when (a) {
            1 -> "정수 1입니다."
            "Me" -> "나 임"
            is Long -> "Long 타입"
            !is String -> "String 타입이 아님"
            else -> "만족하는 조건 없음"
        }
        println(result)
    }
//
//    fun doWhen(a: Any) {
//        when (a) {
//            1 -> println("정수 1입니다.")
//            "Me" -> println("나 임")
//            is Long -> println("Long 타입")
//            !is String -> println("String 타입이 아님")
//            else -> println("만족하는 조건 없음")
//        }
//    }
    
}