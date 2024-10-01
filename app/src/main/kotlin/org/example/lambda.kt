package org.example

import org.example.SiteVisit
/**
 * calculate x, y sum
 * @param x y
 * @return Int
 * @throws WrongArgument>
 * @sample my_sum( 1, 2)
*/
val my_sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y}
val action: () -> Unit = { println(42)}
val canReturnNull: (Int, Int) -> Int? = {_ , _ -> null }
val funOrNull: (((Int, Int) -> Int))? = null

fun twoAndThree(operation: (Int, Int) -> Int) {
		val result = operation(2,3)
		println("The result is $result")
}
fun String.myFilter(predicate: (Char) -> Boolean): String {
		val sb = StringBuilder()
		for (index in 0 until length) {
				val element = get(index)
				if(predicate(element)) sb.append(element)
		}
		return sb.toString()
}

// return function
public data class Person (
		val firstName: String,
		val lastName: String,
		val phoneNumber: String?
)

public class ContactListFilters {
		var prefix: String = ""
		var onlyWithPhoneNumber: Boolean = false
		fun getPredicate(): (Person) -> Boolean {
				val startsWithPrefix = {p: Person ->
						p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
				}
				if (!onlyWithPhoneNumber) {
						return startsWithPrefix
				}
				return { startsWithPrefix(it) && it.phoneNumber != null}
		}
}

// remove duplication with lambda
enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }
data class SiteVisit (
		val path: String,
		val duration: Double,
		val os: OS
)
val log = listOf(
		SiteVisit("/", 34.0, OS.WINDOWS),
		SiteVisit("/", 22.0, OS.MAC),
		SiteVisit("/login", 12.0, OS.WINDOWS),
		SiteVisit("/signup", 8.0, OS.IOS),
		SiteVisit("/", 16.3, OS.ANDROID)
)
val averageWindowsDuration: Double = log
		.filter{it.os == OS.WINDOWS}
		.map(SiteVisit::duration)
		.average()
val averageMacDuration: Double = log
		.filter {it.os == OS.MAC}
		.map(SiteVisit::duration)
		.average()

fun Iterable<SiteVisit>.averageDurationFor(os: OS) =
		filter {it.os == os}.map(SiteVisit::duration).average()

fun Iterable<SiteVisit>.averageDuration(predicate: (SiteVisit) -> Boolean) =
    filter (predicate).map(SiteVisit::duration).average()
