package org.example
interface RNG {
		fun nextInt(): Pair<Int, RNG>
}
typealias Rand<A> = (RNG) -> Pair<A, RNG>

val intR: Rand<Int> = {rng -> rng.nextInt()}

fun <A> unit(a: A): Rand<A> = { rng -> a to rng }
fun <A, B> map(s: Rand<A>, f: (A) -> B): Rand<B> =
		{rng ->
				val (a, rng2) = s(rng)
				f(a) to rng2
		}
