package com.gabrielmarcos.features.catalog

import com.gabrielmarcos.features.catalog.data.models.Channel
import com.gabrielmarcos.features.catalog.data.models.ChannelsResponse
import com.gabrielmarcos.features.catalog.data.models.Program
import com.gabrielmarcos.features.catalog.data.models.ProgramsResponse
import com.gabrielmarcos.features.catalog.domain.model.CatalogChannelModel

val channelResponse = ChannelsResponse(
    channels = listOf(Channel(title = "", callLetter = ""))
)

val programResponse = ProgramsResponse(
    programs = listOf(Program(title = ""))
)

val channelInput = Channel(
    title = "Globo",
    callLetter = "Globo"
)

val programsInput = listOf(
    Program(title = "Ep 01"),
    Program(title = "Ep 02"),
)

val catalog = CatalogChannelModel(
    channelTitle = channelInput.title,
    callLetter = channelInput.callLetter,
    currentProgram = programsInput[0].title,
    nextProgram = programsInput[1].title,
    channelImage = "http://cdn-images.online.meo.pt/eemstb/ImageHandler.ashx?evTitle=${channelInput.title}&chCallLetter=${channelInput.callLetter}&profile=16_9&width=320",
    programImage = "http://cdn-images.online.meo.pt/eemstb/ImageHandler.ashx?evTitle=${programsInput[0].title}&chCallLetter=${channelInput.callLetter}&profile=16_9&width=320"
)