/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example

import java.time.LocalDate

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}
sealed class List<out A> {
		companion object {
				fun <A> of(vararg aa: A): List<A> {
						val tail = aa.sliceArray(1 until aa.size)
						return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
				}
		}
}
object Nil : List<Nothing>()
data class Cons<out A> (val head: A, val tail: List<A>) : List<A> ()


val ints = List.of(1,2,3,4)
fun sum(xs: List<Int>): Int =
		when (xs) {
				is Nil -> 0
				is Cons -> xs.head + sum(xs.tail)
		}
class CountingSet<T>(
		val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
		var objectAdded = 0
		override fun add(element: T): Boolean {
				objectAdded++
				return innerSet.add(element)
		}
		override fun addAll(c: Collection<T>): Boolean {
				objectAdded += c.size
				return innerSet.addAll(c)
		}
}
fun main() {
		val result = sum(ints)
		println("sum result : " + result)
    println(App().greeting)
		println(my_sum(1, 2))
		twoAndThree(my_sum)
		twoAndThree({a, b -> a * b})
		println("ab1c".filter { it in 'a'..'z' })
		println("ab1c".myFilter { it in 'a'..'z' })
		// return function

		val contacts = listOf(Person("Dmitry", "Jeremy", "123-4567"), Person("Jane", "ben", null), Person("Dmcall", "lim", "111-2222"))
		val contactListFilters = ContactListFilters()
		with(contactListFilters) {
				prefix = "Dm"
				onlyWithPhoneNumber = true
		}
		println(contacts.filter(contactListFilters.getPredicate()))
		// remove duplication with lambda
		println("average window duration : " + averageWindowsDuration)
		println("average mac duration : " + averageMacDuration)
		println("average mac duration : " + log.averageDurationFor(OS.MAC))
		println("average duration : " + log.averageDuration({it.os in listOf(OS.MAC, OS.WINDOWS)}))
		println("average duration : " + log.averageDuration({it.path == "/login"}))
		val p1 = Point(1,2)
		val p2 = Point(2,3)
		println(p1 + p2)
		println(p1 * 1.5)
		println(1.5 * p1)
		println('a' * 3)
		println(p1[1])
		println(p1[0])
	//	println(p1[2])  // exception
		val mutableP = MutablePoint(1,2)
		mutableP[1] = 10
		println(mutableP)
		val rec = Rectangle(Point(0, 3), Point(3, 0))
		println(Point(1,1) in rec)
		val newYear = LocalDate.ofYearDay(2024,10)
		val daysOff = newYear.minusDays(1)..newYear
		for(dayOff in daysOff) {println(dayOff)}
		runCoroutine()
		runJob()
		testSuspendFunction()
		testSuspendFunction2()
		val cset = CountingSet<Int>()
		cset.addAll(listOf(1,1,2))
		println("${cset.objectAdded} objects added, ${cset.size} remain")
}
