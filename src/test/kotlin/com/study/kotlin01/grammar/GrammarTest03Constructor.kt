package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTest03Constructor {
    @Test
    fun main() {
        var a = Person("박보영", 1990)
        var b = Person("전정국", 1997)
        var c = Person("장원영", 2004)
        var d = Person("이루다")
        var e = Person("차은우")
        var f = Person("류수정")
        var g = Person()


    }

    class Person(var name: String, val birthYear: Int) {
        init {
            println("안녕하세요, ${this.birthYear}년생 ${this.name}입니다.")
        }

        constructor(name: String) : this(name, 1997) {
            println("보조 생성자 사용됨")
        }
        constructor() : this("이름이없음", 1997) {
            println("보조 생성자 사용됨")
        }

    }
}