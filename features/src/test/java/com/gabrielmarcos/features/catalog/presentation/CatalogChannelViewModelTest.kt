package com.gabrielmarcos.features.catalog.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gabrielmarcos.features.catalog.catalog
import com.gabrielmarcos.features.catalog.domain.usecases.GetCatalogChannels
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import java.lang.Exception
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull

@ExperimentalCoroutinesApi
class CatalogChannelViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    private val getCatalogChannels: GetCatalogChannels = mockk(relaxed = true)

    private lateinit var viewModel: CatalogChannelViewModel

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(dispatcher)

        viewModel = CatalogChannelViewModel(getCatalogChannels)
    }

    @AfterTest
    fun cleanup() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when request catalog channels return success then assert channels value`() = dispatcher.runBlockingTest {
        coEvery { getCatalogChannels() } coAnswers { Result.success(listOf(catalog)) }
        viewModel.getChannels()

        val state = viewModel.channels.value

        assertNotNull(state)
        assert(state.isNotEmpty())
    }

    @Test
    fun `when request catalog channels return error then assert channels value`() = dispatcher.runBlockingTest {
        coEvery { getCatalogChannels() } coAnswers { Result.failure(Exception()) }
        viewModel.getChannels()

        val state = viewModel.onError.value
        assertNotNull(state)
    }
}