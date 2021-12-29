plugins {
    id("java-library")
    id("kotlin")
    kotlin(KotlinPlugins.serialization) version KotlinPlugins.serialization_version

}
dependencies{
    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)
}

java{
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility= JavaVersion.VERSION_1_7
}