@file:Suppress("InvalidPackageDeclaration")

import io.petros.movies.config.deps.Deps
import io.petros.movies.config.deps.identifier

plugins {
    id(Plugins.Id.Android.LIBRARY)
    id(Plugins.Id.Kotlin.Android.ANDROID)
    id(Plugins.Id.Quality.DETEKT)
    id(Plugins.Id.Dependency.VERSIONS)
    id(Plugins.Id.Test.JACOCO)
    id(Plugins.Id.Test.COVERAGE)
}

dependencyAnalysis {
    issues {
        onIncorrectConfiguration {
            exclude(
                Deps.Project.Implementation.Kotlin.DOMAIN, // Ignore change to 'api' advice.
                Deps.Project.Implementation.Android.Core.ANDROID_UTILS, // Ignore change to 'api' advice.
                Deps.Material.MATERIAL.identifier(), // Ignore change to 'api' advice.
                Deps.Android.Core.APP_COMPAT.identifier(), // Ignore change to 'api' advice.
                Deps.Android.Core.FRAGMENT.identifier(), // Ignore change to 'api' advice.
                Deps.Android.Core.RECYCLER_VIEW.identifier(), // Ignore change to 'api' advice.
                Deps.Android.Arch.Lifecycle.LIVE_DATA_CORE.identifier(), // Ignore change to 'api' advice.
                Deps.Android.Arch.Lifecycle.VIEW_MODEL.identifier(), // Ignore change to 'api' advice.
                Deps.Architecture.Mvi.STATEFUL.identifier() // Ignore change to 'api' advice.
            )
        }
    }
}

dependencies {
    implementation(project(Deps.Project.Implementation.Kotlin.DOMAIN))
    implementation(project(Deps.Project.Implementation.Android.Core.ANDROID_UTILS))

    implementation(Deps.Kotlin.Core.KOTLIN)
    implementation(Deps.Material.MATERIAL)
    implementation(Deps.Android.Core.APP_COMPAT)
    implementation(Deps.Android.Core.FRAGMENT)
    implementation(Deps.Android.Core.RECYCLER_VIEW)
    implementation(Deps.Android.Arch.Lifecycle.COMMON)
    implementation(Deps.Android.Arch.Lifecycle.COMMON_JAVA_8)
    implementation(Deps.Android.Arch.Lifecycle.LIVE_DATA_CORE)
    implementation(Deps.Android.Arch.Lifecycle.LIVE_DATA_CORE_KTX)
    implementation(Deps.Android.Arch.Lifecycle.VIEW_MODEL)
    implementation(Deps.Architecture.Mvi.STATEFUL)
    implementation(Deps.Image.Glide.GLIDE)
    implementation(Deps.Log.TIMBER)

    testImplementation(project(Deps.Project.TestImplementation.Kotlin.TEST))
    testImplementation(project(Deps.Project.TestImplementation.Android.ANDROID_TEST))

    testImplementation(Deps.Test.JUnit.J_UNIT_4)
    testImplementation(Deps.Test.Assert.STRIKT)
    testImplementation(Deps.Test.Mock.MOCK_K)
    testImplementation(Deps.Android.Test.Robolectric.ROBOLECTRIC)

    detektPlugins(Plugins.DETEKT_FORMATTING)
}
