buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath(GradleDeps.buildGradle)
        classpath(GradleDeps.kotlinGradlePlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}