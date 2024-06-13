import com.geno1024.home.buildsrc.BuildCount
import com.geno1024.home.buildsrc.Dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

dependencies {
    implementation(project(":configs"))
    implementation("org.jetbrains.exposed", "exposed-core", Dependencies.exposedVersion)
    implementation("org.jetbrains.exposed", "exposed-jdbc", Dependencies.exposedVersion)
    implementation("org.jetbrains.exposed", "exposed-java-time", Dependencies.exposedVersion)
    implementation("org.mariadb.jdbc", "mariadb-java-client", "3.3.1")
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
    mainClass = "com.geno1024.home.db.DB"
}
