package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestObject {

    @Test
    fun `오브젝트테스트`() {
        println(Counter.count)

        Counter.countUp()
        Counter.countUp()

        println(Counter.count)

        Counter.countClear()
        println(Counter.count)
    }

    object Counter {
        var count = 0

        fun countUp() {
            count++
        }
        fun countClear() {
            count = 0
        }
    }

    @Test
    fun `오브젝트테스트2`() {
        var a = FoodPoll("짜장")
        var b = FoodPoll("짬뽕")

        a.vote()
        a.vote()

        b.vote()
        b.vote()
        b.vote()

        println("${a.name} : ${a.count}")
        println("${b.name} : ${b.count}")
        println("합계 : ${FoodPoll.total}")

    }

    class FoodPoll(val name: String) {
        //java static멤버와 비슷한 기능 : 클래스 내부에서 별도의 영역에 고정적으로 존재하여 인스턴스를 생성하지 않아도 공용으로 사용가능한 속성이나 함수
        companion object {
            var total = 0
        }
        var count = 0

        fun vote() {
            total++
            count++
        }
    }

}