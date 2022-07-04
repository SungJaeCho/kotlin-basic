package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * 변수의 고급기술. 상수, lateinit, lazy
 * 상수(const val) : 컴파일시점에 생성되며 절대 변경될수 없는 값, companion object 내에서만 선언이 가능하며 대문자와 언더바로 표기됨
 */
class GrammarTestLateInitLazy {

    @Test
    fun `상수테스트`() {
        val foodCourt = FoodCourt()
        foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)
        foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
        foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)
    }

    class FoodCourt {
        fun searchPrice(foodName: String) {
            val price = when (foodName) {
                FOOD_CREAM_PASTA -> 13000
                FOOD_STEAK -> 25000
                FOOD_PIZZA -> 15000
                else -> 0
            }
            println("${foodName}의 가격은 ${price}원 입니다")
        }

        companion object {
            const val FOOD_CREAM_PASTA = "크림파스타"
            const val FOOD_STEAK = "스테이크"
            const val FOOD_PIZZA = "피자"
        }
    }

    @Test
    fun `늦은초기화`() {
        val a = LateInitSample()
        println(a.getLateInitText())
        a.text = "새로 할당한 값"
        println(a.getLateInitText())
    }
    class LateInitSample {
        lateinit var text: String

        fun getLateInitText() : String {
            return if(::text.isInitialized) { // lateinit 변수가 초기화 되면 들어옴
                text
            } else {
                "기본값"
            }
        }
    }

    //lazy : 변수를 사용할때까지 생성을 안함
    @Test
    fun `lazy사용`() {
        val number : Int by lazy {
            println("초기화를 합니다")
            7
        }
        println("코드를 시작합니다.")
        println(number) // 초기화 실행
        println(number) // 이미 초기화 했기때문에 초기화 안함
    }
}