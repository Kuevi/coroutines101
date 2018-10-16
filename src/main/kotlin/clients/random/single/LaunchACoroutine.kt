package clients.random.single

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.get
import kotlinx.coroutines.*
import clients.random.several.SumOfTwo


/**
 * To dispatch wark to different threads/flows/contexts,
 * we launch coroutines
 */
object LaunchingACoroutine



private val URL = "http://127.0.0.1:8080/random"

private val client = HttpClient(Apache)


/**
 * Coroutine scope limit the life cycle
 * */
suspend fun main(args: Array<String>) {
    coroutineScope {
        println("World!")

        launch {

            val value = client.get<String>(URL).toInt()

            println("We got $value")
        }

        println("Hello!")
    }
}






private val `next point` = MaxLaunch
