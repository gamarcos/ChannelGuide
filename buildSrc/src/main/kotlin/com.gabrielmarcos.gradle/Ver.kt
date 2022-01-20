package com.gabrielmarcos.gradle

object Ver {
    // https://maven.google.com/web/index.html
    object Android {
        const val activityCompose = "1.3.1"
        const val appCompat = "1.3.1"
        const val constraint = "2.0.4"
        const val material = "1.1.0"
        const val recyclerview = "1.2.1"
    }

    object Kotlin {
        // https://github.com/JetBrains/kotlin
        const val stdlib = "1.5.21"

        // https://github.com/Kotlin/kotlinx.coroutines
        const val coroutines = "1.6.0"

        // https://github.com/Kotlin/kotlinx.serialization
        const val serialization = "1.2.2"
    }

    object Test {
        // https://github.com/mockk/mockk
        const val mockk = "1.12.1"
    }

    // https://github.com/bumptech/glide/releases
    const val glide = "4.12.0"

    const val gradle = "7.0.2"

    // https://github.com/square/retrofit/releases
    const val retrofit = "2.9.0"

    const val retrofitKotlinxConverter = "0.8.0"

    const val okHttp = "4.9.0"

    const val jetPack = "2.2.0"

    const val koin = "2.1.6"

    const val room = "2.3.0"
}

object Plugin {
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Ver.Kotlin.stdlib}"
    const val kotlinSerialization =
        "org.jetbrains.kotlin:kotlin-serialization:${Ver.Kotlin.stdlib}"
    const val gradle = "com.android.tools.build:gradle:${Ver.gradle}"
}

object Dep {

    object Android {
        const val appCompat = "androidx.appcompat:appcompat:${Ver.Android.appCompat}"
        const val constraint =
            "androidx.constraintlayout:constraintlayout:${Ver.Android.constraint}"
        const val material = "com.google.android.material:material:${Ver.Android.material}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Ver.Android.recyclerview}"
    }

    object Glide {
        const val recyclerView = "com.github.bumptech.glide:recyclerview-integration:${Ver.glide}"
        const val core = "com.github.bumptech.glide:glide:${Ver.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Ver.glide}"
        const val okhttp3 = "com.github.bumptech.glide:okhttp3-integration:${Ver.glide}"
    }

    object Kotlin {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Ver.Kotlin.coroutines}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Ver.Kotlin.coroutines}"
        const val serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Ver.Kotlin.serialization}"

        object Test {
            const val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Ver.Kotlin.stdlib}"
        }
    }

    object Koin {
        const val koin =  "org.koin:koin-core:${Ver.koin}"
        const val koinExt =  "org.koin:koin-core-ext:${Ver.koin}"
        const val koinAndroid =  "org.koin:koin-android:${Ver.koin}"
        const val koinViewModel = "org.koin:koin-android-viewmodel:${Ver.koin}"
    }

    object JetPack {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Ver.jetPack}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Ver.retrofit}"
        const val kotlinxConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Ver.retrofitKotlinxConverter}"
    }

    object OkHttp {
        const val core = "com.squareup.okhttp3:okhttp:${Ver.okHttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Ver.okHttp}"
    }

    object Test {
        object Mockk {
            const val core = "io.mockk:mockk:${Ver.Test.mockk}"
        }
    }

    object Room {
        const val room = "androidx.room:room-runtime:${Ver.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Ver.room}"
        const val roomKtx = "androidx.room:room-ktx:${Ver.room}"
    }
}