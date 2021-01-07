package idiot.types.jvm.conc

import org.junit.Ignore
import org.junit.Test
import java.util.concurrent.Executors

class Interrupts {

    @Test
    @Ignore
    fun `Caught by common jvm method`() {
        Thread {
            try {
                Thread.sleep(10000)
            } catch (e: InterruptedException) {
                // By convention, any method that exits by throwing an InterruptedException clears interrupt status when it does so
                println("internal interrupt, flag: ${Thread.interrupted()}")
            }
        }.apply {
            start()
            Thread.sleep(50)
            interrupt()
            println("external, flag: $isInterrupted")
        }
    }

    @Test
    @Ignore
    fun `Caught manually`() {
        Thread {
            try {
              while(true) {
                  if (Thread.interrupted()) {
                      println("Caught interrupt flag")
                      throw InterruptedException()
                  }
              }
            } catch (e: InterruptedException) {
                println("Exiting")
            }
        }.apply {
            start()
            Thread.sleep(50)
            interrupt()
            println("external: $isInterrupted")
        }
    }

    @Test
    @Ignore
    fun `Fixed scheduler postpones task execution if all threads are busy`() {
        val executor = Executors.newFixedThreadPool(2)

        (0..5).forEach {
            executor.submit {
                println("Started: $it")
                Thread.sleep(1000)
                println("Finished: $it")
            }
        }
        Thread.sleep(6000)
    }

    class Concurrent(
            private val tag: String,
            private val child: Concurrent? = null
    ) {
        @Synchronized
        fun op() {
            printThread("$tag Operation start")
            Thread.sleep(100)
            if (child != null) {
                printThread("$tag inner child start")
                child?.op()
                printThread("$tag inner child finish")
            }
            Thread.sleep(100)
            printThread("$tag Operation finish")
        }
    }

    @Test
    @Ignore
    fun `Thread1 blocks until child fun completes in thread2`() {
        val child = Concurrent("Child")
        val parent = Concurrent(tag = "Parent", child = child)

        Executors.newSingleThreadExecutor().submit {
            printThread("Parallel parent access start")
            parent.op()
            printThread("Parallel parent access finish")
        }
        Thread.sleep(30)
        Executors.newSingleThreadExecutor().submit {
            printThread("Parallel child access start")
            child.op()
            printThread("Parallel child access finish")
        }
        Thread.sleep(5000)
    }

    @Test
    @Ignore
    fun `Thread2 blocks until parent and child completes in thread1`() {
        val child = Concurrent("Child")
        val parent = Concurrent(tag = "Parent", child = child)

        Thread {
            printThread("Parallel parent access start")
            parent.op()
            printThread("Parallel parent access finish")
        }.start()
        Thread.sleep(100)
        Thread {
            printThread("Parallel child access start")
            child.op()
            printThread("Parallel child access finish")
        }.start()
        Thread.sleep(5000)
    }

    companion object {
        fun printThread(string: String) = println("T ${Thread.currentThread().id}, $string")
    }

}