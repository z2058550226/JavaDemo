package com.suikajy.demo.kotlin.sequence

fun main() {
    listOf(1, 2, 3).firstOrNull {
        it == 2
    }?.apply { println(this) }
}