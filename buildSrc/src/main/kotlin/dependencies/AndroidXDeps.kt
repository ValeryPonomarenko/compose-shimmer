import org.gradle.api.artifacts.dsl.DependencyHandler

object AndroidXDeps {

    private const val coreKtxVersion = "1.6.0"
    private const val compatVersion = "1.3.1"

    private const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    private const val composeActivity = "androidx.activity:activity-compose:$compatVersion"
    private const val appCompat = "androidx.appcompat:appcompat:$compatVersion"

    fun coreKtx(dependencies: DependencyHandler) =
        dependencies.apply {
            implementation(coreKtx)
        }

    fun composeActivity(dependencies: DependencyHandler) =
        dependencies.apply {
            implementation(composeActivity)
        }

    fun appCompat(dependencies: DependencyHandler) =
        dependencies.apply {
            implementation(appCompat)
        }
}