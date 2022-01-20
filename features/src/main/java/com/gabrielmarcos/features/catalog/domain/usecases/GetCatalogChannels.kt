package com.gabrielmarcos.features.catalog.domain.usecases

import com.gabrielmarcos.config.exceptions.BusinessException
import com.gabrielmarcos.config.storage.CatalogStorage
import com.gabrielmarcos.features.catalog.data.models.ChannelsResponse
import com.gabrielmarcos.features.catalog.domain.mappers.CatalogChannelMapper
import com.gabrielmarcos.features.catalog.domain.model.CatalogChannelModel
import com.gabrielmarcos.features.catalog.domain.repositories.CatalogChannelRepository

private const val SKIP_PAGINATION = 10

class GetCatalogChannels(
    private val repository: CatalogChannelRepository,
    private val mapper: CatalogChannelMapper,
    private val catalogStorage: CatalogStorage
) {

    suspend operator fun invoke(): Result<List<CatalogChannelModel>> {
        val channels = repository.getCatalogChannels(catalogStorage.nextUrlSkipParams.toString())

        if (channels.isFailure)
            return Result.failure(BusinessException(message = channels.exceptionOrNull()?.message))

        return getProgramsByChannel(channels.getOrThrow()).also { updateSkipPaginationParams() }
    }

    private suspend fun getProgramsByChannel(channelResponse: ChannelsResponse): Result<List<CatalogChannelModel>> {
        val channelsCatalog = arrayListOf<CatalogChannelModel>()

        channelResponse.channels.forEach { channel ->
            val programs = repository.getCatalogPrograms(channel.callLetter)

            if (programs.isFailure)
                return Result.failure(BusinessException(message = programs.exceptionOrNull()?.message))

            channelsCatalog.add(
                mapper.mapperCatalogChannel(
                    channel = channel,
                    programs = programs.getOrThrow().programs
                )
            )
        }

        return Result.success(channelsCatalog)
    }

    private fun updateSkipPaginationParams() {
        catalogStorage.nextUrlSkipParams += SKIP_PAGINATION
    }
}