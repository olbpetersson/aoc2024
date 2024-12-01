package aoc2024

import java.io.File

fun String.readFile(): File =
    File(object {}.javaClass.getResource(this)!!.file)

fun String.readFileText(): String =
    object {}.javaClass.getResource(this)!!.readText().trim()