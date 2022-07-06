package com.study.kotlin01.grammar

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test


/**
 * 코루틴을 통한 비동기 처리
 * implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3") 해야함
 * GlobalScope : 프로그램 어디서나 제어, 동작이 가능한 기본 범위
 * CoroutineScope : 특정한 목적의 Dispatcher를 지정하여 제어 및 동작이 가능한 범위
 * Dispatcher.Default : 기본적인 백그라운드 동작
 * Dispatcher.IO : I/O에 최적화 된 동작
 * Dispatcher.Main : 메인(UI) 스레드에서 동작
 * 실행은 launch(반환값이 없는 job객체), async(반환값이 있는 Deferred 객체) 이며 차이점은 반환값이 있는지의 여부
 *
 * delay(millisecond: Long) : millisecond단위로 루틴을 잠시 대기시키는 함수
 * Job.join() : Job의 실행일 끝날때까지 대기하는 함수
 * Deferred.await() : Deferred 의 실행이 끝날때까지 대기하는 함수, 결과값도 반환함
 * 중지 방법
 * 1. 코루틴 내부의 delay() 함수 또는 yield() 함수가 사용된 위치까지 수행된 뒤 종료됨
 * 2. cancel()로 인해 속성인 isActive가 false가 되므로 이를 확인하여 수동으로 종료함
 * withTimeoutOrNull() 제한시간안에 해결되면 반환값을 그게 아니면 null 을 리턴
 */
class GrammarTestAsync {

    @Test
    fun `코루틴테스트1`() {
        runBlocking { // 이안에서 실행하지 않으면 메인함수가 종료되면 바로 종료되므로 비동기가 실행되지 않을수 있음
            val a = launch {
                for (i in 1..5) {
                    println(i)
                    delay(10)
                }
            }

            val b = async {
                "async 종료"
            }
            println("async 대기")
            println(b.await())

            println("launch 대기")
            a.join()
            println("launch 종료")
        }
    }

    @Test
    fun `코루틴테스트2`() {
        runBlocking { // 이안에서 실행하지 않으면 메인함수가 종료되면 바로 종료되므로 비동기가 실행되지 않을수 있음
            val a = launch {
                for (i in 1..5) {
                    println(i)
                    delay(10)
                }
            }

            val b = async {
                "async 종료"
            }
            println("async 대기")
            println(b.await())

            println("launch 취소")
            a.cancel()
            println("launch 종료")
        }
    }

    @Test
    fun `제한시간 함수 테스트`() {
        runBlocking {
            var result = withTimeoutOrNull(50) {
                for (i in 1..10) {
                    println(i)
                    delay(10)
                }
                "Finish"
            }
            println(result)
        }
    }

}