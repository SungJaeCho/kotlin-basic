package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestOverride {

    @Test
    fun 오버라이딩테스트() {
        var tiger = Tiger()
        tiger.eat()
    }

    open class Animal {
        open fun eat() {
            println("음식을 먹습니다.")
        }
    }

    class Tiger : Animal() {
        override fun eat() {
            println("고기를 먹습니다.")
        }
    }
}