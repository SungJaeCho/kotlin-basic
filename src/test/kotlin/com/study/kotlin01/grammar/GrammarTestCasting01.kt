package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestCasting01 {

    @Test
    fun `캐스팅테스트`() {
        var a = Drinks()
        var b = Cola()

        if (b is Cola) {
            println("성공")
        }
        var c  = a as Cola
    }

    open class Drinks{
        var name: String = "음료수"
        open fun drink() {
            println("${name}을 마십니다.")
        }
    }

    class Cola : Drinks() {
        var type: String = "콜라"
        override fun drink() {
            println("${name}인 ${type}을 마십니다.")
        }
        fun taste() {
            println("${type}향이 납니다.")
        }
    }
}