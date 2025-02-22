package com.example.githubapiapp

import com.example.githubapiapp.common.libs

plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-parcelize`
    `kotlinx-serialization`
    kotlin("kapt")
}



android {
    compileSdk = 35

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    tasks.withType<Test> {
        useJUnit()
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    buildFeatures {
        viewBinding = true
    }

    packaging {
        resources.excludes.add("META-INF/*")
        resources.excludes.add("META-INF/versions/9/OSGI-INF/MANIFEST.MF")
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.hilt)
    implementation(libs.junit4)
    implementation(libs.material)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.robolectric)
    kapt(libs.hilt.compiler)
}

kapt {
    correctErrorTypes = true
}
