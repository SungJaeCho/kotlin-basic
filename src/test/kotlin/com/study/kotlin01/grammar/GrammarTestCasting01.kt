package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestCasting01 {

    @Test
    fun `캐스팅테스트`() {
        var a = Drinks()
        a.drink()

        var b:Drinks = Cola()
        b.drink()
//        b.washDishes() 는 호출이 불가하므로 downCasting이 필요함
        if (b is Cola) { // is 캐스팅의 경우 if문안에서만 잠시 downCasting됨
            b.washDishes()
        }
        // as는 그냥 downCastring 처리함
        var c = b as Cola
        c.washDishes()
        b.washDishes() //아까와는 달리 오류가 안나는데 as 캐스팅시 b 변수자체도 다운캐스팅 됨

    }

    open class Drinks{
        var name: String = "음료수"
        open fun drink() {
            println("${name}를 마십니다.")
        }
    }

    class Cola : Drinks() {
        var type: String = "콜라"
        override fun drink() {
            println("${name}중 ${type}을(를) 마십니다.")
        }
        fun washDishes() {
            println("${type}로 설거지를 합니다.")
        }
    }
}