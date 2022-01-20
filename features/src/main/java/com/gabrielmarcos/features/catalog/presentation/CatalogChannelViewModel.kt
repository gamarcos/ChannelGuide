package com.gabrielmarcos.features.catalog.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielmarcos.features.catalog.domain.model.CatalogChannelModel
import com.gabrielmarcos.features.catalog.domain.usecases.GetCatalogChannels
import kotlinx.coroutines.launch

internal class CatalogChannelViewModel(
    private val getCatalogChannels: GetCatalogChannels
) : ViewModel() {

    val channels: MutableLiveData<List<CatalogChannelModel>> = MutableLiveData()
    val onError: MutableLiveData<Unit> = MutableLiveData()

    fun getChannels() {
        viewModelScope.launch {
            getCatalogChannels()
                .onSuccess { channels.value = it }
                .onFailure { onError.value = Unit }
        }
    }
}