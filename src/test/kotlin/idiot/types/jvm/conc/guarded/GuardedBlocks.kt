package idiot.types.jvm.conc.guarded

import org.junit.Ignore
import org.junit.Test
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import kotlin.random.Random

class GuardedBlocks {
    @Test
    @Ignore
    fun waiterWaitsUntilConditionSuffices() {
        val blocks = Waiter()
        Thread {
            blocks.worker.waitAndProceed()
        }.start()
        Thread {
            try {
                Thread.sleep(100L)
            } catch (e: InterruptedException) {
            }
            blocks.condition.set(true)
            println("notifyAll()")
            blocks.worker.notifyCondition()
        }.start()

        Thread.sleep(1000)
    }

    @Test
    @Ignore
    fun produceConsumeCoordination() {
        val drop = Drop()
        // producer
        Thread {
            (0..5).forEach {
                println("> put")
                drop.put("message #$it")
                println("put $it")
                Thread.sleep(Random.nextLong(100))
            }
        }.start()
        // consumer
        Thread {
            (0..5).forEach {
                println("< get")
                val message = drop.get()
                println("got: $message")
                Thread.sleep(Random.nextLong(100))
            }
        }.apply {
            start()
            join()
        }
    }

    @Test
    @Ignore
    fun produceUsingBlockingQueue() {
        val drop = ArrayBlockingQueue<String>(1)
        // producer
        Thread {
            (0..5).forEach {
                println("> put")
                drop.put("message #$it")
                println("put $it")
                Thread.sleep(Random.nextLong(100))
            }
        }.start()
        // consumer
        Thread {
            (0..5).forEach {
                println("< get")
                val message = drop.take()
                println("got: $message")
                Thread.sleep(Random.nextLong(100))
            }
        }.apply {
            start()
            join()
        }
    }
}