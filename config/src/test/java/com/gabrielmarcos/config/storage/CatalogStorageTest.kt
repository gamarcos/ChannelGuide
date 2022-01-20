package com.gabrielmarcos.config.storage

import kotlin.test.Test

class CatalogStorageTest {
    @Test
    fun `assert nextUrlSkipParams initial value is zero`() {
        assert(CatalogStorage.nextUrlSkipParams == 0)
    }
}