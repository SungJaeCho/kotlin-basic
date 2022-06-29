package com.study.kotlin01.grammar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

class GrammarTest {
    @Test
    fun main() {
        println("hello world")

        var a:Int = 10
        var b: Long = a.toLong()
//        println("a: $a b: $b")

        var intArr = arrayOf(1, 2, 3, 4, 5)
        var nullArr = arrayOfNulls<Int>(5)
        var intArr2 : Array<Int> = Array(3) {0}
        var intArr3 : Array<Int> = Array(3) {i->i}
//        println(Arrays.toString(intArr2))
//        println(Arrays.toString(intArr3))

        println(add(5,6,7))

        var uuid:String = UUID.randomUUID().toString()
        println("uuid : $uuid")
        uuid = uuid.substring(0 until 8)
        println("uuid : $uuid")
    }

//    fun add(a: Int, b: Int, c: Int): Int {
//        return a + b + c
//    }
    fun add(a: Int, b: Int, c: Int) = a+b+c

    @Test
    @DisplayName("as연산자테스트")
    fun `as연산자테스트`() {
        val user1 = User("Happy")
        val user2 = User("BTS")
        println(user1 == user2)

        val str = "str"
        if (str is String) {
            println("good")
        }
        if (str !is String) {
            println("not good")
        } else {
            println("good")
        }

        val y: String? = "aaa"
        var x: Int? = y as? Int
        println(x)
    }

    class User(val id: String) {
        override fun equals(o: Any?): Boolean {
            val otherUser = o as? User ?: return false
            return otherUser.id  == id
        }
    }

}