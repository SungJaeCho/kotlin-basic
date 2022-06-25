package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestAbstract {

    @Test
    fun 추상화테스트() {
        var rabbit = Rabbit()
        rabbit.eat()
        rabbit.sniff()

    }

    abstract class Animal {
        abstract fun eat()
        fun sniff() {
            println("킁킁")
        }
    }

    class Rabbit : Animal() {
        override fun eat() {
            println("당근을 먹습니다.")
        }
    }
}