rootProject.name = "spring-kotlin-reflection"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        val kotlinVersion: String by System.getProperties()
        val sonarqubeVersion: String by System.getProperties()
        val dokkaVersion: String by System.getProperties()

        kotlin("jvm") version kotlinVersion
        id("org.sonarqube") version sonarqubeVersion
        id("org.jetbrains.dokka") version dokkaVersion

        val nexusPublishPluginVersion: String by System.getProperties()
        id("io.github.gradle-nexus.publish-plugin") version nexusPublishPluginVersion

        val gradleReleasePluginVersion: String by System.getProperties()
        id("net.researchgate.release") version gradleReleasePluginVersion
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val bomVersion: String by System.getProperties()
            version("bom", bomVersion)
            library("bom", "dev.mbo", "spring-boot-bom").versionRef("bom")
        }
    }
}