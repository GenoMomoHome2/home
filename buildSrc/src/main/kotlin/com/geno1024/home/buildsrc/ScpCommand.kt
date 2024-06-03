package com.geno1024.home.buildsrc

object ScpCommand
{
    fun copy(fromFile: String, toHost: String, toPort: Int = 22, toUser: String, toFile: String)
    {
        if (toFile.isEmpty()) return
        RunCommand.run(arrayOf("ssh", "-oPubkeyAcceptedKeyTypes=+ssh-rsa", "$toUser@$toHost", "rm -r $toFile/*"))
        RunCommand.run(arrayOf("scp", "-r", "-oPubkeyAcceptedKeyTypes=+ssh-rsa", "-P", "$toPort", fromFile, "$toUser@$toHost:$toFile"))
    }
}
