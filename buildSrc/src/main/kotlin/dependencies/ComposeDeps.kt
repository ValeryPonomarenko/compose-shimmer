import org.gradle.api.artifacts.dsl.DependencyHandler

object ComposeDeps {

    const val composeVersion = "1.0.1"

    private const val ui = "androidx.compose.ui:ui:$composeVersion"
    private const val animation = "androidx.compose.animation:animation:$composeVersion"
    private const val foundation = "androidx.compose.foundation:foundation:$composeVersion"
    private const val material = "androidx.compose.material:material:$composeVersion"


    fun all(dependencies: DependencyHandler) =
        dependencies.apply {
            implementation(ui)
            implementation(animation)
            implementation(foundation)
            implementation(material)
        }

    fun ui(dependencies: DependencyHandler) =
        dependencies.apply {
            implementation(ui)
        }

    fun animation(dependencies: DependencyHandler) =
        dependencies.apply {
            implementation(animation)
        }
}