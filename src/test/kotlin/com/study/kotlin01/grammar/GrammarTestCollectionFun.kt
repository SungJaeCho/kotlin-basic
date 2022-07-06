package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * 컬렉션 함수 : list, set, map과 같은 컬렉션 또는 배열에 일반함수 또는 람다함수 형태를 사용하여 for문 없이도 아이템을 순회하며 참조하거나
 * 조건을 걸고 구조의 변경까지 가능한 여러가지 함수
 */
class GrammarTestCollectionFun {

    @Test
    fun `컬렉션함수 테스트1`() {
        val nameList = listOf("박수영", "김지수", "김다현", "신유나", "김지우")
        nameList.forEach { print("$it ") }
        println()

        println(nameList.filter { it.startsWith("김") })
        val nameList2 = nameList.filter { it.startsWith("김") }.map{ "이름 :  $it"} // 조건을 넣으면 그값을 컬렉션으로 반환
        println(nameList2)
        println(nameList.any { it == "김지연" }) //김지연이라는 이름을 가진 데이터가 하나라도 존재하면 true 반환
        println(nameList.all { it.length == 3 }) //리스트에 담긴 모든 데이터의 하나하나의 길이가 3이어야지만 true 반환
        println(nameList.none{ it.startsWith("이") }) // 이씨성을 가진 사람이 하나도 없어야 true반환

        println(nameList.first { it.startsWith("김") }) // 김씨성을 가진 리스트의 첫번째 사람
        println(nameList.last { it.startsWith("김") }) // 김씨성을 가진 리스트의 마지막 사람
        println(nameList.count { it.contains("지") }) // 이름에 지 라는 글자가 들어가는 사람 수
    }

    @Test
    fun `컬렉션함수 테스트2`() {
        // associateBy : 아이템에서 key를 추출하여 map 으로 변환하는 함수
        // groupBy : key가 같은 아이템 끼리 배열로 묶어 map 으로 만드는 함수
        // partition : 아이템에 조건을 걸어 두개의 컬렉션으로 나누어 줌
        data class Person(val name: String, val birthYer: Int)

        val personList = listOf(
            Person("가나", 1992),
            Person("유나", 1992),
            Person("조이", 1996),
            Person("츄", 1999),
            Person("유나", 2003)
        )
        println(personList.associateBy{ it.birthYer }) // person객체의 년도를 기준으로 map을 만들어 출력
        println(personList.groupBy { it.name }) // person객체의 이름을 기준으로 묶어 map을 만들어 출력

        val (over98, under98) = personList.partition { it.birthYer > 1998 }
        println(over98)
        println(under98)
    }

    @Test
    fun `컬렉션함수 테스트3`() {
        // flatMap : 아이템마다 만들어진 컬렉션을 합쳐서 반환하는 함수
        // getOrElse : 인덱스 위치에 아이템이 있으면 아이템을 반환하고 아닌경우 지정한 기본값을 반환하는 함수
        // zip : 컬렉션 두 개의 아이템을 1:1로 매칭하여 새 컬렉션을 만들어 줌, 결과 리스트의 갯수는 더 작은 컬렉션을 따르게됨

        val numbers = listOf(-3, 7, 2, -10, 1)
        println(numbers.flatMap { listOf(it*10, it+10) }) // [-30, 7, 70, 17, 20, 12, -100, 0, 10, 11]  리턴됨
        println(numbers.getOrElse(1) {50}) // 7반환
        println(numbers.getOrElse(10) {50}) // 50반환

        val names = listOf("A","B","C","D")
        println(names zip numbers) // [(A, -3), (B, 7), (C, 2), (D, -10)]  반환
    }

}