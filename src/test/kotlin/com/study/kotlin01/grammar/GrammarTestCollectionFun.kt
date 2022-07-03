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
        val nameList2 = nameList.map{ "이름 :  $it"} // 조건을 넣으면 그값을 컬렉션으로 반환
        println(nameList2)
        println(nameList.any { it == "김지연" }) //김지연이라는 이름을 가진 데이터가 하나라도 존재하면 true 반환
        println(nameList.all { it.length == 3 }) //리스트에 담긴 모든 데이터의 하나하나의 길이가 3이어야지만 true 반환
        println(nameList.none{ it.startsWith("이") }) // 이씨성을 가진 사람이 하나도 없어야 true반환

        println(nameList.first { it.startsWith("김") }) // 김씨성을 가진 리스트의 첫번째 사람
        println(nameList.last { it.startsWith("김") }) // 김씨성을 가진 리스트의 마지막 사람
        println(nameList.count { it.contains("지") }) // 이름에 지 라는 글자가 들어가는 사람 수
    }
}