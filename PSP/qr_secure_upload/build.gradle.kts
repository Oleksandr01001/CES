plugins {
    kotlin("jvm") version "2.2.20"
    application
}

group = "app"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.3.12")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.12")
    implementation("io.ktor:ktor-server-sessions-jvm:2.3.12")
    implementation("io.ktor:ktor-server-call-logging-jvm:2.3.12")
    implementation("io.ktor:ktor-server-status-pages-jvm:2.3.12")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("com.google.zxing:core:3.5.3")
}

application {
    mainClass.set("app.MainKt")
}

kotlin {
    jvmToolchain(24)
}
