package com.gabrielmarcos.features.catalog.di

import com.gabrielmarcos.config.di.ModuleProvider
import com.gabrielmarcos.config.network.RETROFIT_QUALIFIER
import com.gabrielmarcos.config.storage.CatalogStorage
import com.gabrielmarcos.features.catalog.data.api.CatalogService
import com.gabrielmarcos.features.catalog.data.repositories.CatalogChannelRepositoryImpl
import com.gabrielmarcos.features.catalog.domain.mappers.CatalogChannelMapper
import com.gabrielmarcos.features.catalog.domain.repositories.CatalogChannelRepository
import com.gabrielmarcos.features.catalog.domain.usecases.GetCatalogChannels
import com.gabrielmarcos.features.catalog.presentation.CatalogChannelViewModel
import kotlinx.coroutines.MainScope
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

class CatalogModule : ModuleProvider {
    override val module: Module by lazy {
        module {
            single { get<Retrofit>(RETROFIT_QUALIFIER).create(CatalogService::class.java) }

            single<CatalogChannelRepository> {
                CatalogChannelRepositoryImpl(service = get())
            }

            factory { CatalogChannelMapper }

            single { CatalogStorage }

            factory { GetCatalogChannels(repository = get(), catalogStorage = get(), mapper = get()) }

            factory { MainScope() }

            factory { CatalogChannelViewModel(getCatalogChannels = get()) }

        }
    }
}