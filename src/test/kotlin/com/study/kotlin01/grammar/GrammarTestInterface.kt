package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestInterface {

    @Test
    fun 인터페이스테스트() {
        var dog = Dog()
        dog.run()
        dog.eat()

    }

    interface Runner {
        fun run()
    }

    interface Eater {
        fun eat() {
            println("음식을 먹습니다.")
        }
    }

    class Dog : Runner, Eater {
        override fun run() {
            println("우다다다 뜁니다.")
        }
    }
}