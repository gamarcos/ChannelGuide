package com.gabrielmarcos.features.catalog.domain.mappers

import com.gabrielmarcos.features.BuildConfig
import com.gabrielmarcos.features.catalog.data.models.Channel
import com.gabrielmarcos.features.catalog.data.models.Program
import com.gabrielmarcos.features.catalog.domain.model.CatalogChannelModel

object CatalogChannelMapper {

    fun mapperCatalogChannel(
        channel: Channel,
        programs: List<Program>
    ): CatalogChannelModel {
        return CatalogChannelModel(
            channelTitle = channel.title,
            callLetter = channel.callLetter,
            currentProgram = programs.getOrNull(0)?.title ?: "",
            nextProgram = programs.getOrNull(1)?.title ?: "",
            channelImage = buildUrlImage(channel.title, channel.callLetter),
            programImage = buildUrlImage(programs.getOrNull(0)?.title ?: "", channel.callLetter)
        )
    }

    private fun buildUrlImage(baseImage: String, callLetter: String) =
        "${BuildConfig.IMAGE_URL}?evTitle=${baseImage}&chCallLetter=${callLetter}&profile=16_9&width=320"
}