package com.suikajy.demo.kotlin.exception

import com.suikajy.demo.command.CL
import java.io.BufferedWriter
import java.io.File
import java.io.IOException

fun main() {
    test1()

}

@Throws(IOException::class)
fun test1() {
    val dir = File("./testFile")

    if (dir.exists().not()) {
        dir.mkdir()
    }

    val testFile = File(dir, "test1.txt")

    testFile.bufferedWriter().use {
        it.write("test test")
    }
}





