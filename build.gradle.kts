import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Date

plugins {
    `maven-publish`
    kotlin("jvm") version "1.4.10"
    id("org.jetbrains.dokka") version "1.4.10.2"
    id("com.jfrog.bintray") version "1.8.5"
}
group = "dev.jhseo"
version = "1.1.0"

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.dokkaHtml.configure {
    outputDirectory.set(rootDir.resolve("docs"))

    moduleName.set("hasher")
}

val sourcesJar = task<Jar>("sourcesJar") {
    classifier = "sources"
    from("src/main/kotlin")
}

publishing {
    publications {
        register("BintrayRelease", MavenPublication::class) {
            from(components["kotlin"])

            artifactId = "hasher"
            groupId = project.group as String
            version = project.version as String

            artifact(sourcesJar)
        }
    }
}

bintray {
    user = "jhseo1107"
    key = System.getenv("BINTRAY_KEY")
    setPublications("BintrayRelease")
    with(pkg) {
        repo = "maven"
        name = "hasher"
        vcsUrl = "https://github.com/jhseo1107/hasher.git"
        issueTrackerUrl = "https://github.com/jhseo1107/hasher/issues"
        publicDownloadNumbers = true
        publish = true
        setLicenses("MIT")
        version.name = project.version as String
        version.released = Date().toString()
    }
}

val kotestVersion = "4.3.1"
dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:${kotestVersion}") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:${kotestVersion}") // for kotest core jvm assertions
    testImplementation("io.kotest:kotest-property:${kotestVersion}") // for kotest property test
}
