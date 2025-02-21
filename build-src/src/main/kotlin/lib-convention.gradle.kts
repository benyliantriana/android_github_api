package com.example.githubapiapp

import com.example.githubapiapp.common.libs

plugins {
    `android-library`
    `kotlin-android`
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

    packaging {
        resources.excludes.add("META-INF/*")
        resources.excludes.add("META-INF/versions/9/OSGI-INF/MANIFEST.MF")
    }
}

dependencies {
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
}

kapt {
    correctErrorTypes = true
}
