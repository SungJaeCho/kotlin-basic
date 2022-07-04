package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

/**
 * 비트연산 : 정수형의 값을 비트단위로 나누어 데이터를 좀더 작은 단위로 담아 경제성을 높이기 위한 용도로 사용
 */
class GrammarTestBit {

    @Test
    fun `비트 테스트`() {
        var bitData: Int = 0b10000
        bitData = bitData or(1 shl 2) // 1이라는 값을 shl를 이용항 좌측으로 2번 이동 -> 0b100이 됨
        println(bitData.toString(2)) // 2진수의 값으로 출력, 10100 출력됨

        var result = bitData and(1 shl 4) // 1이라는 값을 shl을 사용하여 좌측으로 4번 이동
        println(result.toString(2)) // 10000

        println(result shr 4)

        bitData = bitData and ((1 shl 4).inv()) // 1이라는 값을 shl을 사용하여 좌측으로 4번 밀어줌 이후 inv()함수를 사용하여 값을 반전
        println(bitData.toString(2)) // clear됨

        println((bitData xor(0b10100)).toString(2)) // 마지막으로 현재 bitData가 10100과 같은지 비트별로 확인하기 위해 xor연산을 하여 출력 (하위) 다섯번째 비트만 다르기 때문에 10000 출력
    }
}