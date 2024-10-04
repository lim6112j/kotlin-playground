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
