plugins {
    kotlin("jvm") version "2.1.20"
    // Plugin for Dokka - KDoc generating tool
    id("org.jetbrains.dokka") version "1.9.20"
    application
}

group = "setu.ie"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // dependencies for logging
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.0")
    implementation("org.slf4j:slf4j-simple:2.0.16")

    //For Streaming to XML and JSON
    implementation("com.thoughtworks.xstream:xstream:1.4.18")
    implementation("org.codehaus.jettison:jettison:1.4.1")

    // For generating a Dokka Site from KDoc
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.9.20")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}