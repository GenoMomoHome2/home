package com.geno1024.home.planet

import java.net.InetAddress
import java.net.ServerSocket
import kotlin.concurrent.thread

object Server
{
    var serverThread: Thread? = null

    fun start(port: Int)
    {
        serverThread = thread {
            ServerSocket(port, 0, InetAddress.getByAddress(byteArrayOf(0, 0, 0, 0))).apply {
                while (serverThread?.isInterrupted != true) {
                    val socket = accept()
                    val input = socket.getInputStream()
                    val header = ByteArray(4)
                    input.read(header)
                    println(header)
                }
                close()
            }
        }
    }

    fun stop()
    {
        serverThread?.interrupt()
    }
}
