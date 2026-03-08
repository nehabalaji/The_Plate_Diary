pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ThePlateDiary"
include(":app")
include(":core:common")
include(":core:ui")
include(":core:network")
include(":core:data")
include(":core:domain")
include(":feature:auth")
include(":feature:dashboard")
include(":feature:food-log")
include(":feature:goals")
include(":feature:recipes")
include(":feature:profile")
