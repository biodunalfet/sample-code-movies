@file:Suppress("InvalidPackageDeclaration")

/* PLUGINS */

plugins {
    id(PluginIds.Kotlin.KOTLIN)
    id(PluginIds.Quality.DETEKT)
    id(PluginIds.Dependency.VERSIONS)
    id(PluginIds.Test.JACOCO)
}

/* DEPENDENCIES */

dependencies {
    implementation(project(Project.Implementation.Kotlin.UTILS))

    implementation(Deps.Kotlin.Core.KOTLIN)
    implementation(Deps.Kotlin.Coroutines.CORE)
    implementation(Deps.Di.Koin.Kotlin.CORE)

    testImplementation(project(Project.TestImplementation.Kotlin.TEST))

    testImplementation(Deps.Kotlin.Coroutines.Test.TEST)
    testImplementation(Deps.Test.Spek.DSL)
    testImplementation(Deps.Test.Spek.J_UNIT_5)
    testRuntimeOnly(Deps.Kotlin.Core.KOTLIN_REFLECT)
    testImplementation(Deps.Test.JUnit.J_UNIT_4)
    testRuntimeOnly(Deps.Test.JUnit.J_UNIT_5)
    testImplementation(Deps.Test.Assert.STRIKT)
    testImplementation(Deps.Test.Mock.MOCK_K)

    detektPlugins(Deps.Plugin.DETEKT_FORMATTING)
}
