package idiot.types.jvm.conc

import org.junit.Ignore
import org.junit.Test

class Joins {
    @Test
    @Ignore
    fun `To completion`() {
        Thread {
            println("1")
            Thread.sleep(50)
            println("2")
        }.apply {
            start()
            join()
            println("3")
        }
    }

    @Test
    @Ignore
    fun `To interruption`() {
        Thread {
            println("1")
            try {
                Thread.sleep(100)
            } catch (e: InterruptedException) {
                println("2")
            }
        }.apply { targetOp@
            start()
            Thread {
                Thread.sleep(50)
                targetOp@this.interrupt()
            }.start()
            join()
            println("3")
        }
    }

    @Test
    @Ignore
    fun `Is interrupted`() {
        Thread {
            println("1")
            Thread.sleep(100)
        }.apply { parent@
        start()
            Thread {
                try {
                    parent@this.join()
                } catch (e: InterruptedException) {
                    println("Join wait has been interrupted")
                }
            }.apply {
                start()
                Thread.sleep(50)
                interrupt()
            }
        }
    }
}