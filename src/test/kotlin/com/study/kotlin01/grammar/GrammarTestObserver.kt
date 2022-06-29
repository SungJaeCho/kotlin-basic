package com.study.kotlin01.grammar

import org.junit.jupiter.api.Test

class GrammarTestObserver {

    @Test
    fun main() {
        EventPrinter().start()
    }
    interface EventListener {
        fun onEvent(count: Int)
    }

    class Counter(var listener: EventListener) {
        fun count() {
            for(i in 1..100) {
                if(i % 5 == 0) listener.onEvent(i)
            }
        }
    }
    // 옵저버적용
//    class EventPrinter : EventListener {
//        override fun onEvent(count: Int) {
//            print("${count}-")
//        }
//        fun start() {
//            val counter = Counter(this)
//            counter.count()
//        }
//    }
    //익명객체적용
    class EventPrinter {
        fun start() {
            val counter = Counter(object: EventListener {
                override fun onEvent(count: Int) {
                    print("${count}-")
                }
            })
            counter.count()
        }
    }
}