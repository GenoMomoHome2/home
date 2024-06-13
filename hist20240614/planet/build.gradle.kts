import com.geno1024.home.buildsrc.BuildCount
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

// <editor-fold desc="Build Counter">
val runCount = BuildCount("run")
val jarCount = BuildCount("jar")

tasks.register("runCount") {
    group = "buildcount"
    doLast {
        runCount.inc()
    }
}

tasks.register("jarCount") {
    group = "buildcount"
    doLast {
        jarCount.inc()
    }
}
// </editor-fold>

tasks.withType<KotlinCompile> {
    dependsOn(tasks.getByName("runCount"))
}

tasks.withType<Jar> {
    dependsOn(tasks.getByName("jarCount"))
}

application {
    mainClass = "com.geno1024.home.planet.Planet"
}
