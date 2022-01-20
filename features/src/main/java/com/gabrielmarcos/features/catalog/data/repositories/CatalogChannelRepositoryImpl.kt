package com.gabrielmarcos.features.catalog.data.repositories

import com.gabrielmarcos.features.catalog.data.api.CatalogService
import com.gabrielmarcos.features.catalog.data.models.ChannelsResponse
import com.gabrielmarcos.features.catalog.data.models.ProgramsResponse
import com.gabrielmarcos.features.catalog.domain.repositories.CatalogChannelRepository

class CatalogChannelRepositoryImpl(
    val service: CatalogService
) : CatalogChannelRepository {
    override suspend fun getCatalogChannels(skipParam: String): Result<ChannelsResponse> = try {
        val result = service.getChannels(skip = skipParam)
        Result.success(result)
    } catch (error: Exception) {
        Result.failure(error)
    }

    override suspend fun getCatalogPrograms(callLetter: String): Result<ProgramsResponse> = try {
        val result = service.getPrograms(filter = "CallLetter eq '${callLetter}'")
        Result.success(result)
    } catch (error: Exception) {
        Result.failure(error)
    }
}