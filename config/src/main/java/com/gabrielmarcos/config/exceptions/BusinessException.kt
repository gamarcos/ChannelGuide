package com.gabrielmarcos.config.exceptions

open class BusinessException(
    override val cause: Throwable? = null,
    override val message: String? = null,
    val code: Int? = null
) : RuntimeException(cause)
