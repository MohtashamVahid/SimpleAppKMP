package com.vahidmohtasham.globalstror.core.network

import io.ktor.client.*

expect class KtorClientFactory() {
    fun create(): HttpClient
}
