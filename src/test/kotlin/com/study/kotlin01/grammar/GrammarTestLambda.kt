package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestLambda {

    @Test
    fun main() {
        b(::a)
//        var c: (String) -> Unit = { str:String -> println("$str 람다함수") }
//        var c = {str:String -> println("$str 람다함수2") }
        var c:(String) -> Unit = { println("$it 람다함수3") }
        b(c)
    }

    fun a(str: String) {
        println("$str 함수 a")
    }
    fun b(function: (String) -> Unit) {
        function("b가 호출한")
    }

    @Test
    fun `스코프함수테스트`() {

        var price = 5000

        var a = Book("코틀린", 10000).apply {
            name = "[초특가]$name"
            discount()
        }

        a.run {
            println("상품명 : ${name}, 가격: ${price}원") //현재함수의 변수값을 우선시 함
        }
        a.let {
            println("상품명 : ${it.name}, 가격: ${it.price}원")
        }
        println("a name: ${a.name} a price : ${a.price}")

//        var b = a.run {
//            println(a.price)
//            a.name
//        }
//        println("b = $b")


    }

    class Book(var name: String, var price: Int) {
        fun discount() {
            price -= 2000
        }
    }


}