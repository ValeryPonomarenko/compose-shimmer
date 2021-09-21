plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = AppConfig.targetSdkVersion

    defaultConfig {
        applicationId = "me.vponomarenko.compose.shimmer.example"

        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures.compose = true
    composeOptions {
        kotlinCompilerExtensionVersion = ComposeDeps.composeVersion
    }
}

dependencies {
    implementation(project(":shimmer"))

    KotlinDeps.stdlib(this)
    AndroidXDeps.coreKtx(this)
    AndroidXDeps.composeActivity(this)
    AndroidXDeps.appCompat(this)
    ComposeDeps.all(this)
}