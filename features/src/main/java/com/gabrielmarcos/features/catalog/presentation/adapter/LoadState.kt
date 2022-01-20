package com.gabrielmarcos.features.catalog.presentation.adapter

sealed class LoadState {
    object Loading: LoadState()
    object Done: LoadState()
}