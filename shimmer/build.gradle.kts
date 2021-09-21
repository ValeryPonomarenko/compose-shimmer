plugins {
    id("com.android.library")
    id("maven-publish")
    kotlin("android")
}

group = ShimmerConfig.group
version = ShimmerConfig.version

android {
    compileSdk = AppConfig.targetSdkVersion

    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures.compose = true
    composeOptions {
        kotlinCompilerExtensionVersion = ComposeDeps.composeVersion
    }
}

dependencies {
    AndroidXDeps.coreKtx(this)
    ComposeDeps.ui(this)
    ComposeDeps.animation(this)
}

afterEvaluate {
    publishing {
        publications {
            create("release", MavenPublication::class) {
                from(components.getByName("release"))
                groupId = ShimmerConfig.group
                artifactId = ShimmerConfig.artifact
                version = ShimmerConfig.version
            }
        }
    }
}