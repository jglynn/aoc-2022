package org.jglynn.aoc

import java.io.File
import java.net.URI

/**
 * Reads lines from the given input txt file.
 */
internal object Utils {

    fun resourceAsListOfString(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    fun loadAsListOfInt(name: String): List<Int> {
        return resourceAsListOfString(name).map { it.toInt() }
    }

    fun loadAsListOfStringIntPair(name: String): List<Pair<String,Int>> {
        return resourceAsListOfString(name).map() {
            val (direction, value) = it.split(" ")
            Pair(direction, value.toInt())
        }
    }

    private fun String.toURI(): URI =
        Utils.javaClass.classLoader.getResource(this)?.toURI() ?: throw IllegalArgumentException("Cannot find Resource: $this")
 }