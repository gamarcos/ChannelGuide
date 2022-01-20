package com.gabrielmarcos.features.catalog.data.repositories

import com.gabrielmarcos.features.catalog.channelResponse
import com.gabrielmarcos.features.catalog.data.api.CatalogService
import com.gabrielmarcos.features.catalog.domain.repositories.CatalogChannelRepository
import com.gabrielmarcos.features.catalog.programResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

class CatalogChannelRepositoryImplTest {

    private var service: CatalogService = mockk(relaxed = true)

    lateinit var channelCatalogRepository: CatalogChannelRepository

    @BeforeTest
    fun setup() {
        channelCatalogRepository = CatalogChannelRepositoryImpl(service = service)
    }

    @Test
    fun `when request channels return result success with channel response then assert isSuccess`() =
        runBlocking {
            coEvery { service.getChannels(skip = "0") } returns channelResponse

            val channels = channelCatalogRepository.getCatalogChannels("0")

            assert(channels.isSuccess)
        }

    @Test
    fun `when request channels throw an exceptions then assert result failure`() = runBlocking {
        coEvery { service.getChannels(skip = "0") } throws Exception()

        val channels = channelCatalogRepository.getCatalogChannels(skipParam = "0")

        assert(channels.isFailure)
    }

    @Test
    fun `when request programs return result success with channel response then assert isSuccess`() =
        runBlocking {
            val callLetter = "0"

            coEvery { service.getPrograms(filter = "CallLetter eq '${callLetter}'") } returns programResponse

            val programs =
                channelCatalogRepository.getCatalogPrograms("CallLetter eq '${callLetter}'")

            assert(programs.isSuccess)
        }
}