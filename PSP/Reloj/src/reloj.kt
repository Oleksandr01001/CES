import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val jobs = mutableListOf<Job>()
        for (table in 1..10){
            val job = launch {
                print("soy la tabla del $table \n")

                for (i in 1..10){
                    println("$table * $i ${table* i}")
                }
            }
            jobs.add(job)

        }
        jobs.joinAll()
    }
}