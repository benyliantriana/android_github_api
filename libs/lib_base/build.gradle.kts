plugins {
    id("com.example.githubapiapp.lib-convention")
}

android {
    namespace = "com.example.githubapiapp.lib_base"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
