package com.geno1024.home.buildsrc

import java.io.File

class BuildCount(val key: String)
{
    fun write(i: Int): Int = i.apply {
        File("$key-count.txt").writeText(toString())
    }

    fun init() = write(0)

    fun read(): Int = File("$key-count.txt").takeIf(File::exists)?.let { it.readText().trim().toIntOrNull()?:init() }?:init()

    fun inc() = File("$key-count.txt").takeIf(File::exists)?.let { write(it.readText().trim().toIntOrNull()?.inc()?:1) }?:write(1)
}
