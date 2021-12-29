plugins {
    id("java-library")
    id("kotlin")
    kotlin(KotlinPlugins.serialization) version KotlinPlugins.serialization_version
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
dependencies{

    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)

    implementation(project(mapOf("path" to ":entities")))
}