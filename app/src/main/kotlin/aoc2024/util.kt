package aoc2024

import java.io.File

fun String.readFile(): File =
    File(object {}.javaClass.getResource(this)!!.file)

fun String.readFileText(
    overrideValue: String? = null
): String =
    overrideValue ?: File(object {}.javaClass.getResource(this)!!.file).readText().trim()