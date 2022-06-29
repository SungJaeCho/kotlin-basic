package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * 제네릭 : 클래스나 함수에서 사용하는 자료형을 외부에서 지정할수 있는 기능
 */
class GrammarTestGeneric {

    @Test
    fun `제네릭테스트`() {
        UsingGeneric(A()).doShouting() // UsingGeneric<A> (A()).doShouting() 의 생략본
        UsingGeneric(B()).doShouting()
        UsingGeneric(C()).doShouting()

        doShouting(B())
//        doShouting(D()) 타입이 안맞음

    }
    open class A {
        open fun shout() {
            println("A가 소리칩니다.")
        }
    }

    class B : A() {
        override fun shout() {
            println("B가 소리칩니다.")
        }
    }

    class C : A() {
        override fun shout() {
            println("C가 소리칩니다.")
        }
    }

    class D{
        fun shout() {
            println("C가 소리칩니다.")
        }
    }

    // <T : A> ==> 슈퍼클래스를 A로 제한한 제너릭 T 선언
    // val t : T ==> 생성자에서는 제너릭 T에 맞는 인스턴스를 속성 t로 받음
    class UsingGeneric<T : A>(private val t: T) {
        fun doShouting() {
            t.shout()
        }
    }

    // 함수에서 사용
    // fun뒤에 슈퍼클래스를 A로 제한한 제너릭 T를 선언하고
    fun <T : A> doShouting(t: T) {
        t.shout()
    }
}