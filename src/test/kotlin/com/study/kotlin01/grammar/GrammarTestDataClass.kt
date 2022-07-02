package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * 데이터를 관리하는데 최적화된 클래스로 5가지 기능을 내부적으로 자동으로 생성
 * 1. equals() 내용의 동일성
 * 2. hashCode() 참조주소의 동일성
 * 3. toString()
 * 4. copy() 객체를 복사하여 똑같은 내용의 새 객체를 만듬
 * 5. componentX() 속성을 순서대로 반환
 */
class GrammarTestDataClass {

    @Test
    fun `일반적인클래스와 데이타클래스와 비교`() {
        val a = General("보영", 212)
        println(a == General("보영", 212))
        println(a.hashCode())
        println(a)

        val b = Data("루다", 111)
        println(b == Data("루다", 111))
        println(b.hashCode())
        println(b)

        println(b.copy())
        println(b.copy("아린"))
        println(b.copy(id = 618))

    }

    class General(val name: String, val id: Int)
    data class Data(val name: String, val id: Int)

    @Test
    fun `componentX의 기능`() {
        val list = listOf(Data("보영", 212),
            Data("루다", 306),
            Data("아린", 618))

        for((a,b) in list) {
            println("$a, $b")
        }
    }


}