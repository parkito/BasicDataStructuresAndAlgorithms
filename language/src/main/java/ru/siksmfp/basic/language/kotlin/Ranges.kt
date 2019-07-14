package ru.siksmfp.basic.language.kotlin


fun main() {
    while (true) {
        while (true) {
            var a: Map<Int, String>? = null
            for (i in 1..java.util.Random().nextInt()) {
                a = mapOf(1 to "1", 2 to "2")
                println(a)
                Thread.sleep(1000)
            }

        }
    }
}