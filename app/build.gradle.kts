import com.android.build.api.dsl.Packaging

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.route.route_task"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.route.route_task"
        minSdk = 30
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        dataBinding = true
        viewBinding = true
    }
    fun Packaging.() {
        exclude("META-INF/LICENSE.md")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
    }
}

kapt {
    correctErrorTypes = true
}
dependencies {

    //Rounded Image
    implementation (libs.roundedimageview)
    //Hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)// replace with the latest version
    annotationProcessor (libs.hilt.compiler)

    //Shimmer Effect
    implementation (libs.shimmer)
    //Gilde
    implementation (libs.glide)
    //lifeCycle ViewModel
    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
    kapt (libs.androidx.hilt.compiler)
    implementation (libs.androidx.fragment.ktx)

    //mockk
    testImplementation (libs.mockk)
    androidTestImplementation (libs.mockk.android)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(project(":domain"))
    implementation(project(":data"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
