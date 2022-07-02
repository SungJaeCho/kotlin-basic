package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestEnumClass {

    @Test
    fun `ENUM 클래스`() {
        var state = State.SING
        println(state)

        state = State.SLEEP
        println(state.isSleeping())

        state = State.EAT
        println(state)
    }
    enum class State(val message: String) {
        SING("노래를 부릅니다"),
        EAT("밥을 먹습니다"),
        SLEEP("잠을 잡니다");

        fun isSleeping() = this == SLEEP
    }

}