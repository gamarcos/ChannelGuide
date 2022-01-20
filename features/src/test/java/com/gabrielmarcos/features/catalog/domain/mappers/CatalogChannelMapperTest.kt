package com.gabrielmarcos.features.catalog.domain.mappers

import com.gabrielmarcos.features.catalog.channelInput
import com.gabrielmarcos.features.catalog.catalog
import com.gabrielmarcos.features.catalog.programsInput
import kotlin.test.Test
import kotlin.test.assertEquals

class CatalogChannelMapperTest {

    @Test
    fun `when map catalog channel then assert return expected value`() {
        val result = CatalogChannelMapper.mapperCatalogChannel(
            channel = channelInput,
            programs = programsInput
        )
        assertEquals(catalog, result)
    }
}