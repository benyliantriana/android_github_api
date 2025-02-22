plugins {
    id("com.example.githubapiapp.lib-convention")
}

android {
    namespace = "com.example.githubapiapp.lib_base"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}
