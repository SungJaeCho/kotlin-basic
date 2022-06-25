package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestExtend {

    @Test
    fun 상속테스트() {
        var a = Animal("별이", 5, "개")
        var b = Dog("별이", 5)

        a.introduce()
        b.introduce()
        b.bark()

        var c = Cat("나비", 2)
        c.introduce()
        c.meow()

    }

    // open을 붙여야 상송이 가능하게됨
    open class Animal(var name: String, var age: Int, var type: String) {
        fun introduce() {
            println("저는 ${this.type} ${this.name}이고, ${this.age}살 입니다.")
        }
    }

    class Dog (name: String, age: Int) : Animal (name, age, "개") {
        fun bark() {
            println("멍멍")
        }
    }

    class Cat(name: String, age: Int) : Animal(name, age, "고양이") {
        fun meow() {
            println("야옹")
        }
    }

}