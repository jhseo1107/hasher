import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}
group = "dev.jhseo"
version = "1.0.0"

repositories {
    mavenCentral()
}

tasks.withType<Test>() {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

val kotestVersion = "4.3.1"
dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:${kotestVersion}") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:${kotestVersion}") // for kotest core jvm assertions
    testImplementation("io.kotest:kotest-property:${kotestVersion}") // for kotest property test
}