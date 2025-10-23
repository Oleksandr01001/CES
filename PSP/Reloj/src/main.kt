import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

object main2 {
    private val requestsSent = AtomicInteger(0)

    @JvmStatic
    fun main(args: Array<String>) {
        val targetUrl = "http://192.168.2.216/dashboard/faq.html"
        val threads = 50
        val requestsPerThread = 1000

        val client = OkHttpClient()
        val executor = Executors.newFixedThreadPool(threads)

        println("Starting load test...")

        for (i in 0..<threads) {
            executor.submit(Runnable {
                for (j in 0..<requestsPerThread) {
                    try {
                        val request = Request.Builder()
                            .url(targetUrl)
                            .head()
                            .build()

                        client.newCall(request).execute().close()
                        val count = requestsSent.incrementAndGet()

                        if (count % 100 == 0) {
                            println("Requests sent: " + count)
                        }
                    } catch (e: Exception) {
                        println("Request failed: " + e.message)
                    }
                }
            })
        }

        executor.shutdown()
        while (!executor.isTerminated()) {

        }

        println("Total requests sent: " + requestsSent.get())
    }
}