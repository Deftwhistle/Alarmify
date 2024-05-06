plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.alarmify"
    compileSdk = 34



    defaultConfig {
        applicationId = "com.example.alarmify"
        minSdk = 24
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

    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.preference)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation("androidx.fragment:fragment-ktx:1.7.0")
    implementation ("com.google.android.material:material:1.12.0")
    implementation ("com.android.support:appcompat-v7:28.0.0")
    implementation ("com.android.support.constraint:constraint-layout:2.0.4")
    implementation ("com.squareup.picasso:picasso:2.5.2")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("com.android.support.test:runner:1.0.2")




}