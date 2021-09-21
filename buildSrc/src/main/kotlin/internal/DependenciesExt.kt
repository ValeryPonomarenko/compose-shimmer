import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

internal fun DependencyHandler.implementation(dependency: Any): Dependency? =
    add("implementation", dependency)