package com.gabrielmarcos.channelguide

import android.app.Application
import com.gabrielmarcos.config.network.NetworkModule
import com.gabrielmarcos.features.catalog.di.CatalogModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
        }

        loadKoinModules(
            listOf(
                NetworkModule().provideModule(),
                CatalogModule().provideModule(),
            )
        )
    }
}