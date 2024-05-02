package com.geno1024.home.buildsrc

object ScpCommand
{
    fun copy(fromFile: String, toHost: String, toPort: Int = 22, toUser: String, toFile: String)
    {
        val r = Runtime.getRuntime()
        val p = r.exec(arrayOf("scp", "-r", "-oPubkeyAcceptedKeyTypes=+ssh-rsa", "-P", "$toPort", fromFile, "$toUser@$toHost:$toFile"))
        p.inputReader().forEachLine(::println)
        p.errorReader().forEachLine(System.err::println)
        p.waitFor()
    }
}