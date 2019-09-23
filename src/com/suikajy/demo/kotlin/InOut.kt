package com.suikajy.demo.kotlin

fun main() {
    println("ss")
    val animal: Animal<in Fish> = Dog()
}

open class Animal<T> {

    open fun eat(food: T) {
        println("Animal eat $food")
    }
}

class Rabbit : Animal<Grass>() {
    override fun eat(food: Grass) {
        println("Rabbit eat $food")
    }
}

open class Dog : Animal<Meat>() {
    override fun eat(food: Meat) {
        println("Dog eat $food")
    }
}

class FishEatDog : Dog() {
    override fun eat(food: Meat) {
        println("FishEatDog eat $food")
    }
}

open class Food

class Grass : Food()

open class Meat : Food()

class Fish : Meat()