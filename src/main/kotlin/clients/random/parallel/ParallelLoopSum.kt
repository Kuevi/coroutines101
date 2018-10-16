package clients.random.parallel.loopsum

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.get
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

object ParallelLoopSum


private val URL = "http://127.0.0.1:8080/random/slow"

private val client = HttpClient(Apache)


suspend fun main(args: Array<String>) = coroutineScope {
    val list = mutableListOf<Deferred<Int>>()

    repeat(10) {
        val deferred = async { client.get<String>(URL).toInt() }

        list += deferred
    }

    val sum = list.sumBy { it.await() }

    println("Sum of 10 random values is $sum")
}



private object MeasureLoop {
    @JvmStatic
    fun main(args: Array<String>) {
        val mills = measureTimeMillis {
            runBlocking {
                clients.random.parallel.loopsum.main(args)
            }
        }

        println("Execution time is $mills ms")
    }
}





private val `next point` = 0