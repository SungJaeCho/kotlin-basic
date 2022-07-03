package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestSetMap {

    @Test
    fun `SET 테스트`() {
        val a = mutableSetOf("귤", "바나나", "키위")
        for(item in a){
            println("item = $item")
        }
        a.add("자몽")
        println(a)

        a.remove("바나나")
        println(a)

        println(a.contains("귤"))
    }

    @Test
    fun `MAP 테스트`() {
        val a = mutableMapOf(
            "레드벨벳" to "빨간맛",
            "트와이스" to "FANCY",
            "ITZY" to "ICY"
        )
        for(entry in a){
            println("${entry.key} : ${entry.value}")
        }
        a.put("오마이걸", "번지")
        println(a)

        a.remove("ITZY")
        println(a)

        println(a["레드벨벳"])
        println(a.get("레드벨벳"))
    }

}