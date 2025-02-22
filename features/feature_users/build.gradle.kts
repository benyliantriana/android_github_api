plugins {
    id("com.example.githubapiapp.feature-convention")
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.githubapiapp.feature_users"
}

dependencies {
    implementation(project(":libs:lib_network"))
}
