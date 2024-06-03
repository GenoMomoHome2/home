package com.geno1024.home.buildsrc

object RunCommand
{
    fun run(command: Array<String>) = Runtime.getRuntime().exec(command).apply {
        inputReader().forEachLine(::println)
        errorReader().forEachLine(System.err::println)
        waitFor()
    }
}
