import org.jetbrains.kotlin.gradle.idea.tcs.extras.isIdeaProjectLevelKey

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.room.ksp)
}

android {
    namespace = "com.example.sqlmcqapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.sqlmcqapplication"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.splashscreen.dependency)
    implementation(libs.livedata)
    implementation(libs.viewmodel)
    implementation(libs.viewmodel.savedstate)
    implementation(libs.gson.dependency)
    implementation(libs.room.runtime)
    implementation(libs.room.compiller.processor)
    implementation(libs.room.coroutine.support.dependency)
    ksp(libs.room.compiller.processor)
    implementation(libs.coroutine.core)
    implementation(libs.coroutine.android)
    implementation(libs.billingclient)
    implementation(libs.event.bus)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}