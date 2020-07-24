@file:Suppress("InvalidPackageDeclaration")

import io.petros.movies.config.deps.Deps
import io.petros.movies.config.deps.Projects
import io.petros.movies.config.deps.identifier

plugins {
    id(Plugins.Id.Android.LIBRARY)
    id(Plugins.Id.Kotlin.Android.ANDROID)
    id(Plugins.Id.Kotlin.KAPT)
    id(Plugins.Id.Quality.DETEKT)
    id(Plugins.Id.Dependency.VERSIONS)
}

dependencies {
    implementation(project(Projects.Implementation.Kotlin.UTILS))
    implementation(project(Projects.Implementation.Kotlin.DOMAIN))

    implementation(Deps.Kotlin.Core.KOTLIN)
    implementation(Deps.Kotlin.Coroutines.CORE_JVM)
    implementation(Deps.Android.Arch.Database.SQLight.SQLIGHT)
    implementation(Deps.Android.Arch.Room.COMMON)
    implementation(Deps.Android.Arch.Room.RUNTIME)
    implementation(Deps.Android.Arch.Room.KTX)
    kapt(Deps.Android.Arch.Room.COMPILER)
    implementation(Deps.Android.Arch.Pagination.COMMON)
    implementation(Deps.Di.Koin.Kotlin.CORE)

    detektPlugins(Plugins.DETEKT_FORMATTING)
}

dependencyAnalysis {
    issues {
        onIncorrectConfiguration {
            exclude(
                Projects.Implementation.Kotlin.DOMAIN, // Ignore change to 'api' advice.
                Deps.Kotlin.Core.KOTLIN.identifier(), // Ignore change to 'api' advice.
                Deps.Kotlin.Coroutines.CORE_JVM.identifier(), // Ignore change to 'api' advice.
                Deps.Android.Arch.Room.RUNTIME.identifier(), // Ignore change to 'api' advice.
                Deps.Android.Arch.Pagination.COMMON.identifier(), // Ignore change to 'api' advice.
                Deps.Di.Koin.Kotlin.CORE.identifier() // Ignore change to 'api' advice.
            )
        }
    }
}
