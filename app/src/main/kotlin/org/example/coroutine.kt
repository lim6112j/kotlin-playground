package org.example
import kotlinx.coroutines.*

fun runCoroutine() = runBlocking {
		launch {doBlock()}
		println("Hello")
}
suspend fun doBlock() {
		delay(1000L)
		println("World")
}
fun runJob() = runBlocking{
		val job = launch {
				delay(1000L)
				println("world")
		}
		println("Hello")
		job.join()
		println("Done")
}
suspend fun delayAndHelloCoroutine() {
		delay(100L)
		println("Hello Coroutines")
}
fun testSuspendFunction() = runBlocking{
		val startTime = System.currentTimeMillis()
		delayAndHelloCoroutine()
		delayAndHelloCoroutine()
		println("testSuspendFunction finished in ${System.currentTimeMillis() - startTime}")}

fun testSuspendFunction2() = runBlocking{
		val startTime = System.currentTimeMillis()
		val job1 = launch {
				delayAndHelloCoroutine()
		}
		val job2 = launch {
				delayAndHelloCoroutine()
		}
		job1.join()
		job2.join()
		println("testSuspendFunction with new coroutines finished in ${System.currentTimeMillis() - startTime}")
}
