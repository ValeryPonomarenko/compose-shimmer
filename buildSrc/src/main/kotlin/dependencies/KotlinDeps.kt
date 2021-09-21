import org.gradle.api.artifacts.dsl.DependencyHandler

object KotlinDeps {

    const val kotlinVersion = "1.5.21"

    private const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"

    fun stdlib(dependencies: DependencyHandler) =
        dependencies.apply {
            implementation(stdlib)
        }

}