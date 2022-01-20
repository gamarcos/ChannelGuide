package com.gabrielmarcos.features.catalog.domain.model

data class CatalogChannelModel(
    val channelTitle: String,
    val currentProgram: String,
    val nextProgram: String,
    val programImage: String,
    val channelImage: String,
    val callLetter: String,
)