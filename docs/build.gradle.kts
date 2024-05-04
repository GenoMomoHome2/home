import com.geno1024.home.buildsrc.BuildCount
import com.geno1024.home.buildsrc.Configs
import com.geno1024.home.buildsrc.ScpCommand
import com.geno1024.home.buildsrc.Unzip

// <editor-fold desc="Build Counter">
val runCount = BuildCount("run")

val runCountTask = tasks.register("runCount") {
    group = "buildcount"
    doLast {
        runCount.inc()
        val configContent = project.file("writerside.cfg").readLines().toMutableList()
        val versionLine = configContent.indexOfFirst { line ->
            line.trim().startsWith("<instance src=\"docs.tree\"")
        }
        configContent[versionLine] = configContent[versionLine].replace(Regex("version=\"(.+?)\"")) { "version=\"${runCount.read()}\"" }
        project.file("writerside.cfg").writeText(configContent.joinToString(separator = "\n"))
    }
}

tasks.register("build") {
    group = "build"
    doLast {

    }
}

tasks.register("publish") {
    group = "publish"
    doLast {
        Unzip.unzip(rootProject.file("webHelpDOCS2-all.zip"), rootProject.file("webHelpDOCS2-all"))
        ScpCommand.copy(
            fromFile = rootProject.file("webHelpDOCS2-all").absolutePath,
            toHost = Configs.Docs.host,
            toPort = Configs.Docs.port.toIntOrNull()?:22,
            toUser = Configs.Docs.user,
            toFile = Configs.Docs.target
        )
    }
}
// </editor-fold>
