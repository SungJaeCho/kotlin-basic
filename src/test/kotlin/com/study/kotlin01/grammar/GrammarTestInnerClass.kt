package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * 중첩클래스 : 외부클래스안에 선언된 클래스 : 외부 클래스의 내용을 공유할 수 없음
 * 이너클래스 : 외부클래스의 속성과 함수의 사용이 가능
 */
class GrammarTestInnerClass {

    @Test
    fun `중첩클래스`() {
        Outer.Nested().introduce()

        val outer = Outer()
        val inner = outer.Inner()

        inner.introduceInner()
        inner.introduceOuter()

        outer.text = "Changed Outer Class"
        inner.introduceOuter()


        val nested = Outer.Nested()
        nested.introduce()
    }

    class Outer {
        var text = "Outer Class"

        class Nested {
            fun introduce() {
                println("Nested Class")
            }
        }

        inner class Inner {
            var text = "Inner Class"
            fun introduceInner() {
                println(text)
            }
            fun introduceOuter() {
                println(this@Outer.text) // Outer클래스와 Inner클래스에 같은이름의 속성이나 함수가 있다면 this@OuterClass이름으로 참조
            }
        }
    }
}