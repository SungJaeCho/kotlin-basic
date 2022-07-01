package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * 함수의 argument를 다루는 방법과 infix 함수
 */
class GrammarTestFunction {

    @Test
    fun `함수를다루는방법01`() {
        read(7)
        read("kotlin")
    }

    fun read(x: Int) {
        println("x = 숫자 [${x}]")
    }
    fun read(x: String) {
        println("x = 문자 [${x}]")
    }

    @Test
    fun `디폴트 값을 가지고 있는 함수 테스트`() {
        deliveryItem("짬뽕")
        deliveryItem("책",3)
        deliveryItem("노트북",30, "학교")

        deliveryItem("선물", destination = "친구집")
    }
    fun deliveryItem(name: String, count: Int = 1, destination: String = "집") {
        println("${name}, ${count}개를 ${destination}에 배달하였습니다")
    }

    //같은 자료형을 개수에 상관없이 파라미터로 받고 싶을 때 사용하는 variable number of arguments(vararg) 함수
    // vararg파라미터는 다른 파라미터와 같이 쓸경우 반드시 가장 마지막에 위치해야한다!! fun sample(text: String, vararg x: Int)
    @Test
    fun `vararg 함수 테스트`() {
        sum("문자",1,2,3,4)
    }
    fun sum(text: String, vararg numbers: Int) {
        var sum = 0
        for (n in numbers) {
            sum += n
        }
        println("text = [${text}]")
        println("sum = [${sum}]")
    }

    @Test
    fun `infix 테스트`() {
        println(6 multiply 4) // 6은 Int.multiply의 Int에 해당 (infix 함수가 적용되는 객체 자신 == this), 4는 파라미터인 x에 해당
        println(6 multiply(4)) // 위와 같은동작
    }
    // 함수이름을 infix 함수가 적용될 [자료형.이름] 으로 지정, 클래스지만 클래스는 삭제 함
    private infix fun Int.multiply(x: Int): Int = this * x
}