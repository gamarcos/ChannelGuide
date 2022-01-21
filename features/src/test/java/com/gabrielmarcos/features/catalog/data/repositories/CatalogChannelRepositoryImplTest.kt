package com.gabrielmarcos.features.catalog.data.repositories

import com.gabrielmarcos.features.catalog.channelResponse
import com.gabrielmarcos.features.catalog.data.api.CatalogService
import com.gabrielmarcos.features.catalog.domain.repositories.CatalogChannelRepository
import com.gabrielmarcos.features.catalog.programResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.mockito.ArgumentMatchers.anyString
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
            coEvery { service.getChannels(skip = any()) } returns channelResponse

            val channels = channelCatalogRepository.getCatalogChannels(anyString())

            assert(channels.isSuccess)
        }

    @Test
    fun `when request channels throw an exceptions then assert result failure`() = runBlocking {
        coEvery { service.getChannels(skip = any()) } throws Exception()

        val channels = channelCatalogRepository.getCatalogChannels(skipParam = anyString())

        assert(channels.isFailure)
    }

    @Test
    fun `when request programs return result success with channel response then assert isSuccess`() =
        runBlocking {

            coEvery { service.getPrograms(filter = any()) } returns programResponse

            val programs =
                channelCatalogRepository.getCatalogPrograms(anyString())

            assert(programs.isSuccess)
        }

    @Test
    fun `when request programs throw an exceptions then assert result failure`() = runBlocking {
        coEvery { service.getPrograms(filter = any()) } throws Exception()

        val programs = channelCatalogRepository.getCatalogPrograms(anyString())

        assert(programs.isFailure)
    }
}