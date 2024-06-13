package com.geno1024.home.planet

import kotlin.concurrent.thread

object Planet
{
    @JvmStatic
    fun main(args: Array<String>)
    {
        thread {
            Server.start(8111)
        }
    }
}
