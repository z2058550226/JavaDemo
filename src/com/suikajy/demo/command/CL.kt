package com.suikajy.demo.command

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Command line executor
 */
object CL {

    @JvmStatic
    fun pwd() {
        exec("pwd")
    }

    @JvmStatic
    fun exec(vararg command: String) {
        val rt = Runtime.getRuntime()
        val process: Process = rt.exec(command)

        watch(process)
    }

    fun execAndGet(block: (String) -> Unit, vararg command: String) {
        val rt = Runtime.getRuntime()
        val process: Process = rt.exec(command)

        Thread {
            BufferedReader(InputStreamReader(process.inputStream)).use { input ->
                var line: String? = input.readLine()
                var result = ""
                while (line != null) {
                    result += line

                    line = input.readLine()
                }
                block(result)
            }
        }.start()
    }

    @JvmStatic
    fun watch(process: Process) {
        Thread {
            BufferedReader(InputStreamReader(process.inputStream)).use { input ->
                var line: String? = input.readLine()
                while (line != null) {
                    println(line)

                    line = input.readLine()
                }
            }
        }.start()
    }
}