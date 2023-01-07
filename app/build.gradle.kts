import io.easycontext.BlueprintBuildType

plugins {
    id("easycontext.android.application")
    id("easycontext.android.application.compose")
}

android {
    defaultConfig {
        applicationId = "com.easycontext.blueprint"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = BlueprintBuildType.DEBUG.applicationIdSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = BlueprintBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "io.easycontext.blueprint"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    debugImplementation(libs.androidx.compose.ui.testManifest)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    androidTestImplementation(kotlin("test"))
}

// androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
configurations.configureEach {
    resolutionStrategy {
        force(libs.junit4)
        // Temporary workaround for https://issuetracker.google.com/174733673
        force("org.objenesis:objenesis:2.6")
    }
}
