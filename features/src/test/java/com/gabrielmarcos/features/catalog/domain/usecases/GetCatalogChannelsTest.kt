package com.gabrielmarcos.features.catalog.domain.usecases

import com.gabrielmarcos.config.storage.CatalogStorage
import com.gabrielmarcos.features.catalog.channelResponse
import com.gabrielmarcos.features.catalog.domain.mappers.CatalogChannelMapper
import com.gabrielmarcos.features.catalog.domain.repositories.CatalogChannelRepository
import com.gabrielmarcos.features.catalog.programResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

/*These tests are only passing when run individually, I'm working on understanding the bug */
class GetCatalogChannelsTest {

    private var repository: CatalogChannelRepository = mockk(relaxed = true)

    lateinit var getCatalogChannels: GetCatalogChannels

    private val storage = CatalogStorage

    @BeforeTest
    fun setup() {
        getCatalogChannels = GetCatalogChannels(
            repository = repository,
            mapper = CatalogChannelMapper,
            catalogStorage = storage
        )
    }

    @Test
    fun `when invoke getCatalogChannels then assert return success`() = runBlocking {
        coEvery { repository.getCatalogPrograms(callLetter = "") } returns Result.success(
            programResponse
        )
        coEvery { repository.getCatalogChannels(skipParam = "0") } returns Result.success(
            channelResponse
        )
        val result = getCatalogChannels.invoke()
        assert(result.isSuccess)
    }

    @Test
    fun `when invoke getCatalogChannels and getCatalogPrograms return error then assert return result failure`() =
        runBlocking {
            coEvery { repository.getCatalogPrograms(callLetter = "") } returns Result.failure(
                Exception()
            )
            coEvery { repository.getCatalogChannels(skipParam = "0") } returns Result.success(
                channelResponse
            )
            val result = getCatalogChannels.invoke()
            assert(result.isFailure)
        }

    @Test
    fun `when invoke getCatalogChannels and getCatalogChannels return error then assert return result failure`() =
        runBlocking {
            coEvery { repository.getCatalogPrograms(callLetter = "") } returns Result.success(
                programResponse
            )
            coEvery { repository.getCatalogChannels(skipParam = "0") } returns Result.failure(
                Exception()
            )
            val result = getCatalogChannels.invoke()
            assert(result.isFailure)
        }

    @Test
    fun `when invoke getCatalogChannels and getCatalogChannels return success then assert update next url skip`() =
        runBlocking {

            val initialSkipParam = storage.nextUrlSkipParams

            coEvery { repository.getCatalogPrograms(callLetter = "") } returns Result.success(programResponse)
            coEvery { repository.getCatalogChannels(skipParam = "0") } returns Result.success(channelResponse)

            getCatalogChannels.invoke()

            assert(storage.nextUrlSkipParams == initialSkipParam.plus(10))
        }
}