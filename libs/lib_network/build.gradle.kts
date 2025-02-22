plugins {
    id("com.example.githubapiapp.lib-convention")
}

android {
    namespace = "com.example.githubapiapp.lib_network"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.gson.converter)
}

