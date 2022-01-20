package com.gabrielmarcos.features.catalog.domain.repositories

import com.gabrielmarcos.features.catalog.data.models.ChannelsResponse
import com.gabrielmarcos.features.catalog.data.models.ProgramsResponse

interface CatalogChannelRepository {
    suspend fun getCatalogChannels(skipParam: String): Result<ChannelsResponse>
    suspend fun getCatalogPrograms(callLetter: String): Result<ProgramsResponse>
}