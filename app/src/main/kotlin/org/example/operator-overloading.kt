package org.example

import java.time.LocalDate
public data class Point(val x: Int, val y: Int) {
		/* operator fun plus(other: Point): Point { */
		/* 		return Point(x + other.x, y + other.y) */
		/* } */
		/* override fun toString(): String { */
		/* 		return "x: ${this.x}, y: ${this.y}" */
		/* } */
}
operator fun Point.plus(other: Point): Point {
																			 return Point(x + other.x, y + other.y)
}
operator fun Point.times(scale: Double): Point {
		return Point((x * scale).toInt(), (y * scale).toInt())
}
operator fun Double.times(p: Point): Point {
		return Point((p.x * this).toInt(), (p.y * this).toInt())
}

// different type
operator fun Char.times(count: Int): String {
		return toString().repeat(count)
}

// collection

operator fun Point.get(index: Int): Int {
		return when(index) {
				0 -> x
				1 -> y
				else -> throw IndexOutOfBoundsException("Invalid coordinate index")
		}
}
// collection set
public data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
		when(index) {
				0 -> this.x = value
				1 -> this.y = value
				else -> throw IndexOutOfBoundsException("Invalid coordinate index")
		}
}
// in convention

public data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
		return p.x in upperLeft.x until lowerRight.x  && p.y in upperLeft.y until lowerRight.y
}

// iterator for 'for' loops, ClosedRange ~ x..y

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> {
		return object: Iterator<LocalDate> {
				var current = start
				override fun hasNext() =
						current <= endInclusive
				override fun next() = current.apply {
						current = plusDays(1)
				}
		}
}
