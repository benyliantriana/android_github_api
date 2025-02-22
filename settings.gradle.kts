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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Github Api App"
include(":app")
include(":features:feature_users")
include(":libs:lib_network")
includeBuild("build-src")

// this line is required, somehow the convention has some blocking process, even no test classes there
gradle.startParameter.excludedTaskNames.addAll(listOf(":build-src:testClasses"))
